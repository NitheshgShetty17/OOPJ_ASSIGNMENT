USE calendar;

CREATE TABLE IF NOT EXISTS events (
        id INT AUTO_INCREMENT PRIMARY KEY,
        event_date DATE NOT NULL,
        event_title VARCHAR(255) NOT NULL,
event_description TEXT,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
INSERT INTO events (event_date, event_title, event_description)
VALUES
        ('2024-01-01', 'New Year', 'Start of the year celebration'),
    ('2024-01-26', 'Republic Day', 'Indian Republic Day'),
            ('2024-08-15', 'Independence Day', 'Indian Independence Day'),
            ('2024-10-02', 'Gandhi Jayanti', 'Mahatma Gandhi\'s Birthday'),
            ('2024-11-12', 'Diwali', 'Festival of Lights'),
            ('2024-12-25', 'Christmas', 'Christmas celebrations');
SELECT * FROM events;
drop table calendar;