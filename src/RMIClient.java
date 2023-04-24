
import remote.IRemoteBoard;

import java.rmi.Naming;


public class RMIClient {
    public static void main(String[] args) {
        String hostName = "localhost";
        String serviceName = "HelloWorldService";
        int port = 8000;
        String who = "Bobo";
        if (args.length == 3) {
            hostName = args[0];
            serviceName = args[1];
            who = args[2];
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
