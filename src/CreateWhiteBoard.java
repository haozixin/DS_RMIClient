
import remote.IRemoteBoard;
import remote.IRemoteClient;
import utils.PropertiesUtil;

import java.rmi.Naming;
import java.rmi.RemoteException;


public class CreateWhiteBoard {
    private static final String S = "serviceName";
    public static void main(String[] args) {
        String hostName = "localhost";
        int port = 8000;

        try {
            IRemoteBoard ShareWhiteBoardService = (IRemoteBoard) Naming.lookup(
                    "rmi://" +
                            hostName +":"+
                            port + "/" +
                            PropertiesUtil.getConfig(S,PropertiesUtil.SERVER_CONFIG_PROPERTIES));
            ClientServant client = new ClientServant();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
