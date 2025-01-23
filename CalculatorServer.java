import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            // Create an instance of the calculator implementation
            CalculatorInterface calculator = new CalculatorImplement();

            // Start the RMI registry on port 5000
            LocateRegistry.createRegistry(5000);

            // Bind the remote object to the RMI registry with a name
            Naming.rebind("rmi://localhost:5000/CalculatorService", calculator);

            System.out.println("[Server] Advanced Calculator is ready.");
        } catch (Exception e) {
            System.err.println("[Server] Error: " + e);
            e.printStackTrace();
        }
    }
}
