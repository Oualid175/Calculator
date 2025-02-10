package Calculator.CalculatorDemo;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class App {
    private int a, b;

    // Méthode pour récupérer les nombres de l'utilisateur
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

    // Opérations mathématiques
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

    // Méthode pour exécuter une opération
    void executeOperation(int choice, int a, int b) {
        switch (choice) {
            case 1:
                System.out.println("Result = " + add(a, b));
                break;
            case 2:
                System.out.println("Result = " + sub(a, b));
                break;
            case 3:
                System.out.println("Result = " + mul(a, b));
                break;
            case 4:
                if (b == 0) {
                    System.out.println("Divide by Zero is not allowed.");
                } else {
                    System.out.println("Result = " + div(a, b));
                }
                break;
            default:
                System.out.println("Invalid choice! Please select a valid option.");
        }
    }

    public static void main(String[] args) {
        App app = new App();

        // Mode Arguments en ligne de commande
        if (args.length == 3) {
            try {
                int choice = Integer.parseInt(args[0]);
                int a = Integer.parseInt(args[1]);
                int b = Integer.parseInt(args[2]);

                if (choice < 1 || choice > 4) {
                    System.out.println("Invalid operation! Choose between 1 and 4.");
                    return;
                }
                app.executeOperation(choice, a, b);
                return;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please provide numbers.");
                return;
            }
        }
        // Mode interactif ou fichier input.txt
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        // Vérification si l'entrée provient d'un fichier redirigé
        try {
            if (System.in.available() > 0) {
                System.out.println("Reading from file or redirected input...");
                // Vous pouvez traiter l'entrée standard ici si un fichier est fourni
            }
        } catch (IOException e) {
            System.out.println("Error reading from input stream: " + e.getMessage());
        }

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

                if (choice == 5) {
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                }

                app.input(sc);
                app.executeOperation(choice, app.a, app.b);

            } catch (NoSuchElementException e) {
                System.out.println("No input found! Restarting...");
                sc.nextLine(); // Vider le buffer
            }
        } while (!exit);

        sc.close();
    }
}
