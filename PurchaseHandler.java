import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PurchaseHandler {

    // Database URL, username, and password
    private static final String DB_URL = "jdbc:mysql://localhost:3306/book_store";
    private static final String USER = "root"; // replace with your MySQL username
    private static final String PASSWORD = "Velavan@2019"; // replace with your MySQL password

    public static void main(String[] args) {
        // Example purchase details
        String name = "John Doe";
        String bookName = "Programming in C";
        String phone = "1234567890";
        String email = "john@example.com";
        int quantity = 2;
        String address = "123 Main St, City";

        // Insert purchase into the database
        insertPurchase(name, bookName, phone, email, quantity, address);
    }

    public static void insertPurchase(String name, String bookName, String phone, String email, int quantity, String address) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Establish a connection to the database
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Prepare SQL statement
            String sql = "INSERT INTO purchases (name, book_name, phone, email, quantity, address) VALUES (?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, bookName);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, email);
            preparedStatement.setInt(5, quantity);
            preparedStatement.setString(6, address);

            // Execute the insert
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Purchase recorded successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
