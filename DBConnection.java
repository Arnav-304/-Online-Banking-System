import java.sql.*;

public class DBConnection {
    public static Connection connect() {
        try {
            // Load MS Access JDBC Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String url = "jdbc:ucanaccess://database/banking_db.accdb";
            return DriverManager.getConnection(url);
        } catch (Exception e) {
            System.out.println("Database connection error: " + e.getMessage());
            return null;
        }
    }
}
