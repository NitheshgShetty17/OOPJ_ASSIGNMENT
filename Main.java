import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        // Database URL, username, and password
        String url = "jdbc:mysql://localhost:3306/calendar"; // Replace 'CalendarAppDB' with your database name
        String username = "root"; // Replace with your MySQL username
        String password = "Nikhil@645445"; // Replace with your MySQL password

        try {
            // Attempt to establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("Connected to the MySQL database successfully!");
                System.out.println(connection);
            } else {
                System.out.println("Failed to connect to the MySQL database.");
            }
        } catch (SQLException e) {
            // Handle SQL exceptions
            System.out.println("An error occurred while connecting to the MySQL database:");
            e.printStackTrace();
        }
    }
}