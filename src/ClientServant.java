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
        this.isManager = service.createOrJoinBoard(this);
        // first user is manager automatically
        if (isManager){
            JOptionPane.showMessageDialog(null, "You are the manager of this board");
        }
        else{
            JOptionPane.showMessageDialog(null, "Manager has approved you to join the board");
        }
        startCanvas();
    }
    @Override
    public String getName(){
        return name;
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
        System.out.println("The thread in getNotificationAndClose is: "+Thread.currentThread().getName());
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
