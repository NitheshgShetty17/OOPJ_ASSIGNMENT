import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;

public class DatabaseConnection {
    private static Calendar calendar = Calendar.getInstance();
    private static JTable table;
    private static JLabel monthYearLabel;
    private static DefaultTableModel model;
    private static ArrayList<String[]> events;

    public static void main(String[] args) {
        // Fetch events from the database
        events = DatabaseHelper.fetchEvents();

        // Setup the UI and other components
        JFrame frame = new JFrame("Calendar App by Team Futurists");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 650);

        // Top Panel and Table setup (same as before)

        // Setup other components and event listeners
        // ...

        // Load the calendar with events
        updateCalendar();

        frame.setVisible(true);
    }

    private static void updateCalendar() {
        // Logic to update calendar and display events
        // Use the 'events' list fetched from the database
    }

    // Other methods remain the same
}

