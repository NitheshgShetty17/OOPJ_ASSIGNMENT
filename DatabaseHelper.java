
import java.sql.*;
import java.util.ArrayList;

public class DatabaseHelper {

    public static ArrayList<String[]> fetchEvents() {
        ArrayList<String[]> events = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/calendar"; // Replace with your database URL
        String username = "root"; // Your MySQL username
        String password = " "; // Your MySQL password

        String query = "SELECT * FROM events";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String eventDate = resultSet.getString("event_date");
                String eventTitle = resultSet.getString("event_title");
                String eventDescription = resultSet.getString("event_description");

                events.add(new String[]{eventDate, eventTitle});
                System.out.println("Event: " + eventTitle + " on " + eventDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return events;
    }
}

