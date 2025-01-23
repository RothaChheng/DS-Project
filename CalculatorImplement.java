import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorImplement extends UnicastRemoteObject implements CalculatorInterface {
    
    public CalculatorImplement() throws RemoteException {
        super();
    }

    @Override
    public double add(double num1, double num2) throws RemoteException {
        return num1 + num2;
    }

    @Override
    public double subtract(double num1, double num2) throws RemoteException {
        return num1 - num2;
    }

    @Override
    public double multiply(double num1, double num2) throws RemoteException {
        return num1 * num2;
    }

    @Override
    public double divide(double num1, double num2) throws RemoteException {
        if (num2 == 0) throw new ArithmeticException("Division by zero");
        return num1 / num2;
    }

    @Override
    public double power(double base, double exponent) throws RemoteException {
        return Math.pow(base, exponent);
    }

    @Override
    public double modulus(double num1, double num2) throws RemoteException {
        return num1 % num2;
    }

    @Override
    public double percentage(double num1, double num2) throws RemoteException {
        return (num1 * num2) / 100;
    }

    @Override
    public double squareRoot(double num) throws RemoteException {
        if (num < 0) throw new ArithmeticException("Cannot compute the square root of a negative number");
        return Math.sqrt(num);
    }

    @Override
    public double absoluteValue(double num) throws RemoteException {
        return Math.abs(num);
    }
}
