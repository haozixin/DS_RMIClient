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
    IRemoteBoard board;

    protected ClientServant(String userName) throws RemoteException{
        this.name = userName;
        this.isManager = board.createOrJoinBoard(this);
        // first user is manager automatically
        if (isManager){
            JOptionPane.showMessageDialog(null, "You are the manager of this board");
        }
        else{
            JOptionPane.showMessageDialog(null, "Manager has approved you to join the board");
        }
        startCanvas();
    }

    public String getName(){
        return name;
    }
    public boolean isManager(){
        return isManager;
    }

    @Override
    public void setManager(boolean isManager){
        this.isManager = isManager;
    }





    public void startCanvas(){
        whiteBoard = new FrontEndView(name, isManager);
        whiteBoard.setSize(710,500);
        whiteBoard.setVisible(true);
    }


    @Override
    public void sendMessageLocally(String msg) {
        whiteBoard.addMessage(msg);
    }
}
