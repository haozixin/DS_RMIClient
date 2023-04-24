import remote.IRemoteClient;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientServant extends UnicastRemoteObject implements IRemoteClient {
    protected ClientServant() throws RemoteException {
    }
}
