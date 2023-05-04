import Views.FrontEndView;
import remoteInterfaces.IRemoteBoard;
import remoteInterfaces.IRemoteClient;

import javax.swing.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientServant extends UnicastRemoteObject implements IRemoteClient {
    private FrontEndView whiteBoard;
    private String name;
    private boolean isManager;
    IRemoteBoard service;

    protected ClientServant(String userName, IRemoteBoard remoteBoard) throws RemoteException, NullPointerException {
        this.name = userName;
        this.service = remoteBoard;
        createOrAskJoin();
        addShudownHook();
        startCanvas();
    }

    private void addShudownHook() {
        // add a shutdown hook, when the program is terminated, it will do something
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                System.out.println("Shutting down...");
                if (isManager) {
                    try {
                        service.closeAndNotifyAllUsers(name);
                    } catch (RemoteException e) {
                        System.out.println("RemoteException when closing the board, the server may be down");
                        JOptionPane.showMessageDialog(null,"The server side may be down, we will close the board for you!", "Confirm", JOptionPane.INFORMATION_MESSAGE);
                    }
                }else{
                    try {
                        service.existBoard(name);
                    } catch (RemoteException e) {
                        System.out.println("RemoteException when closing the board, the server may be down");
                        JOptionPane.showMessageDialog(null,"The server side may be down, we will close the board for you!", "Confirm", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
    }

    private void createOrAskJoin() throws RemoteException {
        boolean isRepeated = service.isRepeated(name);
        if (isRepeated){
            JOptionPane.showMessageDialog(null, "This userName is already used, please choose another one");
            System.exit(0);
        }
        boolean isSuccessful = service.createOrJoinBoard(this); // isManager attribute is set in this method
        // first user is manager automatically
        if (isSuccessful){
            if (isManager){
                JOptionPane.showMessageDialog(null, "You are the manager of this board");
            }
            else{
                JOptionPane.showMessageDialog(null, "Manager has approved you to join the board","user join request", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Manager has denied you to join the board", "user join request", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public boolean askJoin(String name) {
        int result = JOptionPane.showConfirmDialog(null, "User "+name+" wants to join the board, do you approve?", "Manager approval", JOptionPane.YES_NO_OPTION);
        return result == JOptionPane.YES_OPTION;
    }

    @Override
    public boolean isManager(){
        return isManager;
    }

    @Override
    public void setManager(boolean isManager){
        this.isManager = isManager;
    }

    @Override
    public void getNotificationAndClose(String s) throws RemoteException {
        if (s == null) {
            System.out.println("Notification is null");
            return;
        }
        whiteBoard.notifyAndClose(s);
    }


    public void startCanvas(){
        whiteBoard = new FrontEndView(name, isManager, service);
        whiteBoard.setSize(710,500);
        whiteBoard.setVisible(true);
    }


    @Override
    public void sendMessageLocally(String msg) {
        whiteBoard.addMessage(msg);
    }
}
