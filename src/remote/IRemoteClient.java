package remote;

import java.rmi.Remote;

public interface IRemoteClient extends Remote {
    void sendMessageLocally(String msg);
    public void setManager(boolean isManager);
}
