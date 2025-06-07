import java.sql.*;

public class BankOperations {
    private Connection conn;

    public BankOperations() {
        conn = DBConnection.connect();
    }

    public void createAccount(String name, double initialDeposit) {
        String query = "INSERT INTO Accounts (HolderName, Balance) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setDouble(2, initialDeposit);
            ps.executeUpdate();
            System.out.println("Account created for " + name);
        } catch (SQLException e) {
            System.out.println("Error creating account: " + e.getMessage());
        }
    }

    public void deposit(int accountId, double amount) {
        String query = "UPDATE Accounts SET Balance = Balance + ? WHERE AccountID = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setDouble(1, amount);
            ps.setInt(2, accountId);
            ps.executeUpdate();
            System.out.println("Deposit successful.");
        } catch (SQLException e) {
            System.out.println("Deposit failed: " + e.getMessage());
        }
    }

    public void withdraw(int accountId, double amount) {
        String query = "UPDATE Accounts SET Balance = Balance - ? WHERE AccountID = ? AND Balance >= ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setDouble(1, amount);
            ps.setInt(2, accountId);
            ps.setDouble(3, amount);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Withdrawal successful.");
            else
                System.out.println("Insufficient funds.");
        } catch (SQLException e) {
            System.out.println("Withdrawal failed: " + e.getMessage());
        }
    }

    // Add more operations like transfer, getAccountDetails etc.
}
