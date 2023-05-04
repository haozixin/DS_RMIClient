package remoteInterfaces;

import java.awt.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IRemoteClient extends Remote {
    void sendMessageLocally(String msg) throws RemoteException;
    void setManager(boolean isManager) throws RemoteException;

    void getNotificationAndClose(String s) throws RemoteException;

    boolean isManager() throws RemoteException;
    String getName() throws RemoteException;

    boolean askJoin(String name) throws RemoteException;
    void updateUserList(ArrayList<String> userList)throws RemoteException;

    void close()throws RemoteException;
    void draw(String mode, Point start, Point end, Color color, String textDraw)throws RemoteException;
}
