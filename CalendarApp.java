import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;

public class CalendarApp {
    private static Calendar calendar = Calendar.getInstance();
    private static JTable table;
    private static JLabel monthYearLabel;
    private static DefaultTableModel model;
    private static ArrayList<String[]> events = new ArrayList<>();

    public static void main(String[] args) {
        preloadEvents();

        JFrame frame = new JFrame("Calendar App by Team Futurists");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 650);

        // Top Panel
        JPanel topPanel = new JPanel(new BorderLayout());
        JButton prevMonth = new JButton("<");
        JButton nextMonth = new JButton(">");
        monthYearLabel = new JLabel(getMonthYear(), SwingConstants.CENTER);
        monthYearLabel.setFont(new Font("Arial", Font.BOLD, 18));
        JLabel appTitle = new JLabel("Calendar App by Team Futurists", SwingConstants.CENTER);
        appTitle.setFont(new Font("Arial", Font.BOLD, 20));
        appTitle.setForeground(Color.DARK_GRAY);

        JPanel navigationPanel = new JPanel();
        navigationPanel.add(prevMonth);
        navigationPanel.add(monthYearLabel);
        navigationPanel.add(nextMonth);

        topPanel.add(appTitle, BorderLayout.NORTH);
        topPanel.add(navigationPanel, BorderLayout.CENTER);

        // Calendar Table
        model = new DefaultTableModel(6, 7) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = new JTable(model);
        setupTable();
        updateCalendar();

        JScrollPane scrollPane = new JScrollPane(table);

        // Button Listeners
        prevMonth.addActionListener(e -> changeMonth(-1));
        nextMonth.addActionListener(e -> changeMonth(1));

        // Add click listener to open dialog
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                int col = table.columnAtPoint(e.getPoint());
                Object value = table.getValueAt(row, col);
                if (value != null) {
                    String date = String.format("%02d-%02d-%04d", Integer.parseInt(value.toString()),
                            calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR));
                    String event = JOptionPane.showInputDialog("Add/Edit Event for " + date + ":");
                    if (event != null && !event.trim().isEmpty()) {
                        events.add(new String[]{date, event});
                        updateCalendar();
                    }
                }
            }
        });

        // Bottom Legends Panel
        JPanel legendsPanel = new JPanel();
        legendsPanel.setLayout(new GridLayout(1, 3));
        legendsPanel.add(createLegend("Red", "Holiday / Festival"));
        legendsPanel.add(createLegend("Blue", "Birthday"));
        legendsPanel.add(createLegend("Green", "National Days"));

        // Frame Layout
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(legendsPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private static void preloadEvents() {
        // Festivals, National Days, and Famous Birthdays
        String[] predefinedEvents = {
                "01-01-2024, New Year", "26-01-2024, Republic Day", "15-08-2024, Independence Day",
                "02-10-2024, Gandhi Jayanti", "31-10-2024, Sardar Vallabhbhai Patel's Birthday",
                "12-11-2024, Diwali", "25-12-2024, Christmas", "08-04-2024, Ugadi", "29-03-2024, Holi",
                "01-11-2024, Karnataka Rajyotsava", "19-06-2024, Ramzan (Eid)", "25-01-2024, Army Day",
                "04-12-2024, Navy Day", "08-10-2024, Air Force Day", "01-05-2024, Labour Day",
                "10-03-2024, Holi", "25-12-2024, Christmas", "14-11-2024, Children's Day",
                "25-12-2024, Christmas", "01-01-2024, New Year", "05-06-2024, World Environment Day",
                "15-08-2024, Independence Day", "02-10-2024, Gandhi Jayanti", "14-04-2024, Ambedkar Jayanti",
                "15-08-2024, Independence Day", "25-09-2024, Ganesh Chaturthi", "13-04-2024, Baisakhi",
                "12-12-2024, National Energy Conservation Day", "15-07-2024, World Youth Skills Day",
                "07-09-2024, Teachers' Day", "08-03-2024, International Women's Day", "04-11-2024, Karwa Chauth",
                "01-05-2024, Maharashtra Day", "05-11-2024, Diwali", "10-09-2024, Onam",
                "14-08-2024, Quit India Movement Day", "24-12-2024, Christmas Eve", "26-12-2024, Boxing Day",
                "01-10-2024, International Coffee Day", "11-11-2024, Veterans Day", "17-03-2024, St. Patrick's Day",
                "05-06-2024, World Environment Day", "21-06-2024, International Yoga Day", "02-12-2024, National Pollution Control Day"
        };

        // Adding events to the list
        for (String event : predefinedEvents) {
            String[] eventDetails = event.split(",");
            events.add(new String[]{eventDetails[0].trim(), eventDetails[1].trim()});
        }
    }

    private static String getMonthYear() {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return months[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.YEAR);
    }

    private static void changeMonth(int delta) {
        calendar.add(Calendar.MONTH, delta);
        updateCalendar();
    }

    private static JPanel createLegend(String color, String label) {
        JPanel legend = new JPanel();
        legend.setLayout(new FlowLayout(FlowLayout.LEFT));
        legend.setBackground(Color.white);
        JLabel colorBox = new JLabel();
        colorBox.setPreferredSize(new Dimension(20, 20));
        if (color.equals("Red")) colorBox.setBackground(Color.RED);
        else if (color.equals("Blue")) colorBox.setBackground(Color.BLUE);
        else if (color.equals("Green")) colorBox.setBackground(Color.GREEN);
        colorBox.setOpaque(true);
        legend.add(colorBox);
        legend.add(new JLabel(label));
        return legend;
    }

    private static void setupTable() {
        String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (int i = 0; i < days.length; i++) {
            table.getColumnModel().getColumn(i).setHeaderValue(days[i]);
        }
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setForeground(Color.BLACK);

                if (value != null) {
                    String date = String.format("%02d-%02d-%04d", Integer.parseInt(value.toString()),
                            calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR));

                    // Sunday as Holiday
                    if (column == 0) {
                        c.setForeground(Color.RED);
                        setText(value + " (Holiday)");
                    }

                    // Check for Predefined Events
                    for (String[] event : events) {
                        if (event[0].equals(date)) {
                            if (event[1].contains("Birthday")) {
                                c.setForeground(Color.BLUE);
                            } else if (event[1].contains("Day") || event[1].contains("Festival")) {
                                c.setForeground(Color.GREEN);
                            } else {
                                c.setForeground(Color.RED);
                            }
                            setText(value + " (" + event[1] + ")");
                        }
                    }
                }
                return c;
            }
        });
    }

    private static void updateCalendar() {
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int firstDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        model.setRowCount(0);
        Object[] row = new Object[7];
        int day = 1;

        // Fill empty cells for days before the first day
        for (int i = 0; i < firstDay; i++) row[i] = null;

        // Fill calendar days
        for (int i = firstDay; day <= daysInMonth; i++) {
            if (i % 7 == 0 && i != 0) {
                model.addRow(row);
                row = new Object[7];
            }
            row[i % 7] = day++;
        }
        model.addRow(row);

        monthYearLabel.setText(getMonthYear());
}
}