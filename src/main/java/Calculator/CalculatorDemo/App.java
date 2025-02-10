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
                while (!sc.hasNextInt()) {
                    System.out.println("Invalid input! Please enter an integer:");
                    sc.next(); // Ignore l'entrée incorrecte
                }
                this.a = sc.nextInt();

                System.out.println("Enter second number:");
                while (!sc.hasNextInt()) {
                    System.out.println("Invalid input! Please enter an integer:");
                    sc.next();
                }
                this.b = sc.nextInt();
                sc.nextLine(); // Éviter tout problème avec `nextLine()`
                break;  
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter integers only.");
                sc.nextLine(); // Vider le buffer
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

        do {
            try {
                System.out.println("\nThis is Calculator App:");
                System.out.println("Choose Option:");
                System.out.println("1 : Addition");
                System.out.println("2 : Subtract");
                System.out.println("3 : Multiply");
                System.out.println("4 : Divide");
                System.out.println("5 : Exit");

                while (!sc.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a number between 1 and 5:");
                    sc.next();
                }
                int choice = sc.nextInt();
                sc.nextLine(); // Consommer le retour à la ligne

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
                        if (app.b == 0) {
                            System.out.println("Divide by Zero is not allowed.");
                        } else {
                            System.out.println("Result = " + app.div(app.a, app.b));
                        }
                        break;
                    case 5:
                        exit = true;
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please select a valid option.");
                }
				
            } catch (NoSuchElementException e) {
                System.out.println("No input found! Restarting...");
                sc.nextLine(); // Vider le buffer
            }
        } while (!exit);

        sc.close();
    }
}
