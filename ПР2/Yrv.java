import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Yrv extends Remote {
    void Calculating(int var1, int var2, int var3) throws RemoteException;
}
