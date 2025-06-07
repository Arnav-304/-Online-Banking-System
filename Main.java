import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankOperations bank = new BankOperations();
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter name: ");
                sc.nextLine(); // consume newline
                String name = sc.nextLine();
                System.out.print("Enter initial deposit: ");
                double amount = sc.nextDouble();
                bank.createAccount(name, amount);
                break;
            case 2:
                System.out.print("Enter account ID: ");
                int id = sc.nextInt();
                System.out.print("Enter amount to deposit: ");
                double dep = sc.nextDouble();
                bank.deposit(id, dep);
                break;
            case 3:
                System.out.print("Enter account ID: ");
                int idW = sc.nextInt();
                System.out.print("Enter amount to withdraw: ");
                double wd = sc.nextDouble();
                bank.withdraw(idW, wd);
                break;
            default:
                System.out.println("Invalid option");
        }

        sc.close();
    }
}
