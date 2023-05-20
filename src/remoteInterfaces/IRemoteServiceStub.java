package remoteInterfaces;

import java.awt.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
/**
 * Author:  Zixin Hao
 * Student ID: 1309180
 */
public interface IRemoteServiceStub extends Remote {
    void sendMessageLocally(String msg) throws RemoteException;
    void setManager(boolean isManager) throws RemoteException;

    void getNotificationAndClose(String s) throws RemoteException;

    boolean isManager() throws RemoteException;
    String getName() throws RemoteException;

    boolean askJoin(String name) throws RemoteException;
    void updateUserList(ArrayList<String> userList)throws RemoteException;

    void close()throws RemoteException;
    void draw(String mode, Point start, Point end, Color color, String textDraw)throws RemoteException;

    void newCanvas() throws RemoteException;

    void receiveImage(byte[] imageBytes) throws RemoteException;
    byte[] sendImage(String filePath) throws RemoteException;

    void jumpNotification(String message) throws RemoteException;
}
