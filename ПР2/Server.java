import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends EquationImpl {
    public Server() {
    }

    public static void main(String[] args) {
        try {
            EquationImpl obj = new EquationImpl();
            Yrv stub = (Yrv) UnicastRemoteObject.exportObject(obj, 0);
            Registry registry = LocateRegistry.createRegistry(8080);
            registry.bind("Equation", stub);
            System.err.println("Server ready");
            Thread.sleep(2147483647L);
        } catch (Exception var4) {
            return;
        }

    }
}