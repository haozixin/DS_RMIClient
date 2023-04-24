import remote.IRemoteBoard;
import remote.IRemoteClient;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class JoinWhiteBoard {
    public static void main(String[] args) {
        System.out.println("JoinWhiteBoard.main");
        String hostName = "localhost";
        String serviceName = "HelloWorldService";
        int port = 8000;
        String userName = "Anonymous";

        IRemoteClient who = null;
        try {
            who = new ClientServant();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }

        if (args.length == 3) {
            hostName = args[0];
            serviceName = args[1];
            userName = args[2];
        }
        else if (args.length == 1) {
            hostName = args[0];
        }
        try {
            IRemoteBoard helloWorldService = (IRemoteBoard) Naming.lookup("rmi://" + hostName +":"+ port + "/" + serviceName);
//            HelloWorldInterface helloWorldService = (HelloWorldInterface) Naming.lookup("rmi://" + hostName + "/" + serviceName);
            System.out.println(helloWorldService.sayHello(who));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
