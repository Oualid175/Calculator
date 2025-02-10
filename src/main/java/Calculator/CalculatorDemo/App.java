package Calculator.CalculatorDemo;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class App {
    private int a, b;

    void input(Scanner sc) {
        while (true) {
            try {
                System.out.println("Enter first number:");
                if (!sc.hasNextInt()) {
                    throw new InputMismatchException();
                }
                this.a = sc.nextInt();
                
                System.out.println("Enter second number:");
                if (!sc.hasNextInt()) {
                    throw new InputMismatchException();
                }
                this.b = sc.nextInt();
                
                break; // Exit the loop when valid input is received
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter integers only.");
                sc.nextLine(); // Clear buffer
            } catch (NoSuchElementException e) {
                System.out.println("No input detected! Exiting program.");
                System.exit(1);
            }
        }
    }

    int add(int a, int b) {
        return a + b;
    }

    int sub(int a, int b) {
        return a - b;
    }

    int mul(int a, int b) {
        return a * b;
    }

    float div(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero!");
        }
        return (float) a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            try {
                System.out.println("\nThis is Calculator App:");
                System.out.println("Choose Option:");
                System.out.println("1 : Addition");
                System.out.println("2 : Subtract");
                System.out.println("3 : Multiply");
                System.out.println("4 : Divide");
                System.out.println("5 : Exit");
                
                if (!sc.hasNextInt()) {
                    throw new InputMismatchException();
                }
                int choice = sc.nextInt();
                
                App app = new App();

                switch (choice) {
                    case 1:
                        app.input(sc);
                        System.out.println("Result = " + app.add(app.a, app.b));
                        break;
                    case 2:
                        app.input(sc);
                        System.out.println("Result = " + app.sub(app.a, app.b));
                        break;
                    case 3:
                        app.input(sc);
                        System.out.println("Result = " + app.mul(app.a, app.b));
                        break;
                    case 4:
                        app.input(sc);
                        if (app.b == 0)
                            System.out.println("Divide by Zero is not allowed.");
                        else
                            System.out.println("Result = " + app.div(app.a, app.b));
                        break;
                    case 5:
                        exit = true;
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please select a valid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine(); // Clear buffer
            } catch (NoSuchElementException e) {
                System.out.println("No input detected! Exiting program.");
                exit = true;
            }
        }
        
        sc.close();
    }
}
