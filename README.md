

# Calendar App by Team Futurists

An interactive Java application to manage events and holidays on a calendar, integrated with a MySQL database.

## Features

### 1. Interactive Calendar Interface:
- View calendar months with color-coded events (holidays, birthdays, and national days).
- Add/edit events for any date.

### 2. Database Integration:
- Store and retrieve events dynamically using MySQL.
- Preloaded events like holidays and festivals.

### 3. Color-coded Legends:
- *Red*: Holidays/Festivals
- *Blue*: Birthdays
- *Green*: National Days

## Technology Stack

- *Programming Language*: Java
- *IDE*: IntelliJ IDEA
- *GUI Framework*: Swing
- *Database*: MySQL
- *JDBC Driver*: MySQL Connector

## Setup Instructions

### 1. Prerequisites
- Java Development Kit (JDK) installed.
- IntelliJ IDEA installed.
- MySQL Database set up.
- MySQL Connector added as a library.

### 2. MySQL Setup

1. Create the calendar database:

    CREATE DATABASE calendar;
    

2. Create the events table:

    USE calendar;
    CREATE TABLE IF NOT EXISTS events (
        id INT AUTO_INCREMENT PRIMARY KEY,
        event_date DATE NOT NULL,
        event_title VARCHAR(255) NOT NULL,
        event_description TEXT,
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    );
    

3. Insert predefined events:

    
    INSERT INTO events (event_date, event_title, event_description)
    VALUES
        ('2024-01-01', 'New Year', 'Start of the year celebration'),
        ('2024-01-26', 'Republic Day', 'Celebration of the Indian Constitution'),
        ('2024-08-15', 'Independence Day', 'India’s Independence Day'),
        ('2024-12-25', 'Christmas', 'Festival of Christmas');
    

### 3. IntelliJ IDEA Setup

1. *Import the Project*:
   - Open IntelliJ IDEA and import your project folder.

2. *Add MySQL Connector*:
   - Go to File > Project Structure > Libraries.
   - Click + and add the MySQL Connector .jar file.

3. *Update Database Credentials*:
   - Update the credentials in DatabaseHelper.java:
     java
     String url = "jdbc:mysql://localhost:3306/calendar";
     String username = "root"; // Replace with your MySQL username
     String password = "your_password"; // Replace with your MySQL password
     

4. *Run the Project*:
   - Open Main.java.
   - Click the Run button in IntelliJ.

## Usage

1. Launch the application from IntelliJ.

2. Use the interactive GUI to:
   - View events for any date.
   - Add or edit events dynamically.

3. Events are stored and retrieved from the database in real time.

## File Structure

- *Main.java*: Application entry point.
- *DatabaseHelper.java*: Manages database connectivity.
- *CalendarApp.java*: Swing-based GUI implementation.

## Legends

- *Red*: Holidays/Festivals
- *Blue*: Birthdays
- *Green*: National Days

## Team Members

- *Nikhil G Shetty*  
LinkedIn: https://www.linkedin.com/in/nikhil-g-shetty-3aba2928b
  
- *Nithesh G Shetty*  
LinkedIn: https://www.linkedin.com/in/nithesh-g-shetty-5ab12533b

