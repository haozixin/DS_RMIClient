import remote.IRemoteClient;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientServant extends UnicastRemoteObject implements IRemoteClient {
    private Canvas whiteBoard;

    protected ClientServant() throws RemoteException {
        startCanvas();
    }
    @Override
    public String test() throws RemoteException {
        System.out.println("print from ClientServant");
        return "String from Server-ClientServant";
    }

    @Override
    public void startCanvas() throws RemoteException {
        whiteBoard = new Canvas();
        whiteBoard.setVisible(true);
        whiteBoard.setSize(730,550);
        whiteBoard.setResizable(false);
    }


}
