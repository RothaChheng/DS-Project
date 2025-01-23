import java.rmi.Naming;
import java.util.Scanner;

public class CalculatorClient {
    private static void printBorder() {
        System.out.println("+---------------------------------------------+");
    }

    public static void main(String[] args) {
        try {
            // Connect to the remote calculator service
            CalculatorInterface calculator = (CalculatorInterface) Naming.lookup("rmi://localhost:5000/CalculatorService");
            Scanner scanner = new Scanner(System.in);

            while (true) {
                printBorder();
                System.out.println("|     WELCOME TO THE ADVANCED CALCULATOR      |");
                printBorder();
                System.out.println("| 1. Add                                      |");
                System.out.println("| 2. Subtract                                 |");
                System.out.println("| 3. Multiply                                 |");
                System.out.println("| 4. Divide                                   |");
                System.out.println("| 5. Power (Base ^ Exponent)                  |");
                System.out.println("| 6. Modulus                                  |");
                System.out.println("| 7. Percentage                               |");
                System.out.println("| 8. Square Root                              |");
                System.out.println("| 9. Absolute Value                           |");
                System.out.println("| 10. Exit                                    |");
                printBorder();
                System.out.print("Enter your choice (1-10): ");

                // Input validation for numeric choice
                int choice;
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("** Invalid choice. Please enter a number between 1 and 10. **");
                    continue;
                }

                // Ensure the input is within the valid range
                if (choice < 1 || choice > 10) {
                    System.out.println("** Invalid choice. Please select a number between 1 and 10. **");
                    continue;
                }

                // Exit the program if the user selects 10
                if (choice == 10) {
                    System.out.println("** Goodbye! Thanks for using the Calculator! **");
                    printBorder();
                    scanner.close();
                    break;
                }

                double num1 = 0.0, num2 = 0.0, result = 0.0;

                // Get inputs for choices that require two numbers
                if (choice >= 1 && choice <= 4 || choice == 6 || choice == 7) {
                    System.out.print("Enter the first number: ");
                    try {
                        num1 = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("** Invalid input. Please enter a valid number.**");
                        continue;
                    }

                    System.out.print("Enter the second number: ");
                    try {
                        num2 = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("** Invalid input. Please enter a valid number. **");
                        continue;
                    }
                }
                // Get input for Power (choice 5) - base and exponent
                else if (choice == 5) {
                    System.out.print("Enter the base: ");
                    try {
                        num1 = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("** Invalid input. Please enter a valid number for the base. **");
                        continue;
                    }

                    System.out.print("Enter the exponent: ");
                    try {
                        num2 = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("** Invalid input. Please enter a valid number for the exponent. **");
                        continue;
                    }
                }
                // Get input for choices 8 (square root) and 9 (absolute value)
                else if (choice == 8 || choice == 9) {
                    System.out.print("Enter the number: ");
                    try {
                        num1 = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                        continue;
                    }
                }

                try {
                    // Perform the selected operation
                    switch (choice) {
                        case 1: // Add
                            result = calculator.add(num1, num2);
                            break;
                        case 2: // Subtract
                            result = calculator.subtract(num1, num2);
                            break;
                        case 3: // Multiply
                            result = calculator.multiply(num1, num2);
                            break;
                        case 4: // Divide
                            result = calculator.divide(num1, num2);
                            break;
                        case 5: // Power
                            result = calculator.power(num1, num2);
                            break;
                        case 6: // Modulus
                            result = calculator.modulus(num1, num2);
                            break;
                        case 7: // Percentage
                            result = calculator.percentage(num1, num2);
                            break;
                        case 8: // Square Root
                            result = calculator.squareRoot(num1);
                            break;
                        case 9: // Absolute Value
                            result = calculator.absoluteValue(num1);
                            break;
                    }

                    // Display the result
                    System.out.printf("Result: %.2f \n", result);

                } catch (ArithmeticException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println("[Client] Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
