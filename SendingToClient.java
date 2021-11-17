import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SendingToClient {
    public SendingToClient() {
    }

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(8080);
            Yrv stub = (Yrv)registry.lookup("Equation");
            stub.Calculating(1, -8, 15);
        } catch (Exception var3) {
            return;
        }

    }
}
