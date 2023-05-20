import Views.FrontEndView;
import remoteInterfaces.IRemoteServiceSkeleton;
import remoteInterfaces.IRemoteServiceStub;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Author:  Zixin Hao
 * Student ID: 1309180
 */
public class ServiceStubServant extends UnicastRemoteObject implements IRemoteServiceStub {
    private FrontEndView whiteBoard;
    private String name;
    private boolean isManager;
    IRemoteServiceSkeleton service;
    ArrayList<String> userList = new ArrayList<>();

    protected ServiceStubServant(String userName, IRemoteServiceSkeleton remoteBoard) throws RemoteException, NullPointerException {
        addShudownHook();
        this.name = userName;
        this.service = remoteBoard;

        createOrAskJoin();
        startCanvas();
        if (!service.synImage(name)){
            JOptionPane.showMessageDialog(null, "There is some problem when synchronizing image!", "Confirm", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    private void addShudownHook() {
        // add a shutdown hook, when the program is terminated, it will do something
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                System.out.println("Shutting down...");
                if (isManager) {
                    try {
                        service.closeAndNotifyAllUsers(name);
                    } catch (Exception e) {
                        System.out.println("RemoteException when closing the board, the server may be down");
                        JOptionPane.showMessageDialog(null, "The server side may be down, we will close the board for you!", "Confirm", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    try {
                        service.existBoard(name);
                    } catch (Exception e) {
                        System.out.println("RemoteException when closing the board, the server may be down");
                        JOptionPane.showMessageDialog(null, "The server side may be down, we will close the board for you!", "Confirm", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
    }

    private void createOrAskJoin() throws RemoteException {
        boolean isRepeated = service.isRepeated(name);
        if (isRepeated) {
            JOptionPane.showMessageDialog(null, "This userName is already used, please choose another one");
            System.exit(0);
        }
        boolean isSuccessful = service.createOrJoinBoard(this); // isManager attribute is set in this method
        // first user is manager automatically
        if (isSuccessful) {
            // if the user is manager, don't need to syn the image
            if (isManager) {
                JOptionPane.showMessageDialog(null, "You are the manager of this board");
            } else {
                JOptionPane.showMessageDialog(null, "Manager has approved you to join the board", "user join request", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Manager has denied you to join the board", "user join request", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void updateUserList(ArrayList<String> userList) throws RemoteException {
        if (whiteBoard == null) {
            this.userList = userList;
        } else {
            whiteBoard.updateUserList(userList);
        }
    }

    @Override
    public boolean askJoin(String name) {
        int result = JOptionPane.showConfirmDialog(null, "User " + name + " wants to join the board, do you approve?", "Manager approval", JOptionPane.YES_NO_OPTION);
        return result == JOptionPane.YES_OPTION;
    }

    @Override
    public boolean isManager() {
        return isManager;
    }

    @Override
    public void setManager(boolean isManager) {
        this.isManager = isManager;
    }

    @Override
    public void getNotificationAndClose(String s) throws RemoteException {
        if (s == null) {
            System.out.println("Notification is null");
            return;
        }
        notifyAndClose(s);
    }

    /**
     * This method is called by remoteBoard to notify the user that the board is closed
     *
     * @param s messages to be displayed
     * @return
     * @throws RemoteException
     */
    private void notifyAndClose(String s) {
        JOptionPane.showMessageDialog(whiteBoard, s);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.exit(0);
            }
        });
        t.start();
    }

    public void close() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.exit(0);
            }
        });
        t.start();
    }

    /**
     * the method will open a new thread to draw the shape in order to avoid concurrency problem
     * (the remote draw and local draw together are performed in the same thread)
     *
     * @param mode
     * @param start
     * @param end
     * @param color
     * @param textDraw
     * @throws RemoteException
     */
    @Override
    public void draw(String mode, Point start, Point end, Color color, String textDraw) throws RemoteException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                whiteBoard.synDraw(mode, start, end, color, textDraw);
            }
        });
        t.start();

    }

    @Override
    public void newCanvas() throws RemoteException {
        whiteBoard.newCanvas();
    }


    public void startCanvas() {
        whiteBoard = new FrontEndView(name, isManager, service);
        whiteBoard.setSize(710, 500);
        whiteBoard.updateUserList(userList);
        whiteBoard.setVisible(true);
    }


    @Override
    public void sendMessageLocally(String msg) {
        whiteBoard.addMessage(msg);
    }

    @Override
    public void receiveImage(byte[] imageBytes) throws RemoteException {
        whiteBoard.updateCanvas(imageBytes);
    }

    public byte[] sendImage(String filePath){
        BufferedImage image = null;
        byte[] imageBytes;
        if (filePath != null) {
            File file = new File(filePath);
            try {
                image = ImageIO.read(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            image = whiteBoard.getCanvasImage();
        }


        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "png", baos);
            baos.flush();
            imageBytes = baos.toByteArray();
            baos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return imageBytes;
    }
}
