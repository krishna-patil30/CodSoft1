import java.util.Scanner;

public class ATMINTERFACE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double availBalance = 5000.0;

        while (true) {
            System.out.println("\n=== ATM MENU ===");
            System.out.println("1. Deposit Cash");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");
            // Input validation for menu choice
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number from 1 to 4.");
                scanner.next(); // Clear invalid input
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount (INR): ");
                    if (scanner.hasNextDouble()) {
                        double depositAmount = scanner.nextDouble();
                        if (depositAmount > 0) {
                            availBalance += depositAmount;
                            System.out.println("You deposited: INR " + depositAmount);
                        } else {
                            System.out.println("Deposit amount must be positive.");
                        }
                    } else {
                        System.out.println("Invalid amount entered.");
                        scanner.next(); // Clear invalid input
                    }
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount (INR): ");
                    if (scanner.hasNextDouble()) {
                        double withdrawalAmount = scanner.nextDouble();
                        if (withdrawalAmount > 0) {
                            if (withdrawalAmount <= availBalance) {
                                availBalance -= withdrawalAmount;
                                System.out.println("You withdrew: INR " + withdrawalAmount);
                            } else {
                                System.out.println("Insufficient funds! Available balance: INR " + availBalance);
                            }
                        } else {
                            System.out.println("Withdrawal amount must be positive.");
                        }
                    } else {
                        System.out.println("Invalid amount entered.");
                        scanner.next(); // Clear invalid input
                    }
                    break;

                case 3:
                    System.out.println("Available Balance: INR " + availBalance);
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
