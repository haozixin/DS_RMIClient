import Views.FrontEndView;
import remote.IRemoteClient;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientServant extends UnicastRemoteObject implements IRemoteClient {
    private FrontEndView whiteBoard;

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
        whiteBoard = new FrontEndView();
//        whiteBoard.setMinimumSize(new java.awt.Dimension(1000, 550));
        whiteBoard.setSize(710,500);
        whiteBoard.setVisible(true);
//        whiteBoard.setResizable(false);

    }


}
