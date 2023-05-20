import remoteInterfaces.IRemoteServiceSkeleton;
import utils.PropertiesUtil;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Locale;

/**
 * Author:  Zixin Hao
 * Student ID: 1309180
 */
public class Client2ForTest {
    private static final String S = "serviceName";
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        // args format =  hostName, port, userName, operation(join/create)
        if (args.length != 3){
            System.out.println("Arguments are not enough, Usage: <server-address> <server-port> <user-name>");
            System.exit(1);
        }

        // Resolve and check whether the server address is valid
        String hostName = args[0];
        try {
            InetAddress.getByName(hostName);
        } catch (UnknownHostException e) {
            System.out.println("Invalid server address, Usage: <server-address> <server-port> <user-name>");
            System.exit(1);
        }

        // Parse and check whether the server port number is valid
        String serverPortStr = args[1];
        int serverPort;
        try {
            serverPort = Integer.parseInt(serverPortStr);
        } catch (NumberFormatException e) {
            System.out.println("Invalid server port, Usage: <server-address> <server-port> <user-name>");
            System.exit(1);
            return;
        }
        if (serverPort < 1024 || serverPort > 49151) {
            System.out.println("Server port out of range, valid range is 1024-49151");
            System.exit(1);
        }

        try {
            String userName = args[2];
            Registry registry = LocateRegistry.getRegistry("localhost", serverPort);
            IRemoteServiceSkeleton ShareWhiteBoardService = (IRemoteServiceSkeleton) registry.lookup(
                    PropertiesUtil.getConfig(S,PropertiesUtil.SERVER_CONFIG_PROPERTIES)
            );
            ServiceStubServant client = new ServiceStubServant(userName, ShareWhiteBoardService);
        } catch (Exception e) {
            e.printStackTrace();
//            System.out.println("Cannot link to server, Please check the server address and port number");
        }
    }
}