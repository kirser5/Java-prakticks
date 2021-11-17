import java.rmi.Remote;
import java.rmi.RemoteException;

class EquationImpl implements Yrv, Remote {
    public EquationImpl() {
    }

    public void Calculating(int a, int b, int c) throws RemoteException {
        int D = b * b - 4 * a * c;
        double x1;
     if (D == 0) {
        x1 = (double)(-b / (2 * a));
        System.out.println("КУ: " + x1);
    }
       else if (D > 0) {
         x1 = ((double) (-b) + Math.sqrt((double) D)) / (double) (2 * a);
         double x2 = ((double) (-b) - Math.sqrt((double) D)) / (double) (2 * a);
         System.out.println("ПКУ: " + x1 + "\nВКУ: " + x2);
     }
         else {
            System.out.println("Корней нет");
        }

    }
}