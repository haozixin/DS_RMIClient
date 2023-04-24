import remote.IRemoteClient;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientServant extends UnicastRemoteObject implements IRemoteClient {
    protected ClientServant() throws RemoteException {
    }
    @Override
    public String test() throws RemoteException {
        System.out.println("print from ClientServant");
        return "String from Server-ClientServant";
    }
}
