import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculatorInterface extends Remote {
    double add(double num1, double num2) throws RemoteException;

    double subtract(double num1, double num2) throws RemoteException;

    double multiply(double num1, double num2) throws RemoteException;

    double divide(double num1, double num2) throws RemoteException;

    double power(double base, double exponent) throws RemoteException;

    double modulus(double num1, double num2) throws RemoteException;

    double percentage(double num1, double num2) throws RemoteException;

    double squareRoot(double num) throws RemoteException;

    double absoluteValue(double num) throws RemoteException;
}
