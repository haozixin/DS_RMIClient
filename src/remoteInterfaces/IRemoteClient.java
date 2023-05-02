package remoteInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRemoteClient extends Remote {
    void sendMessageLocally(String msg) throws RemoteException;
    void setManager(boolean isManager) throws RemoteException;
}
