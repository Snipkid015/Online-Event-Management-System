# Online Event Management System

This is a Java-based Event Management System that enables administrators, event organizers, and attendees to manage and participate in events. The system supports key functionalities like user management, event creation, ticket management, and communication between organizers and attendees.

## Features

### Admin
- **User Management**: Add, update, and delete users with roles (Admin, Event Organizer, Attendee).
- **Event Approvals**: Approve or reject events created by organizers.
- **System Settings**: Manage system-wide settings and configurations.

### Event Organizer
- **Event Creation**: Create, edit, and manage events with details like title, description, date, time, and venue.
- **Ticket Management**: Create and manage tickets for events, specifying price and quantity.
- **Attendee Communication**: Send messages to registered attendees for event updates or notifications.

### Attendee
- **Event Registration**: Register for events created by organizers.
- **Ticket Purchase**: Purchase tickets for events, if available.
- **Receive Updates**: Subscribe to receive notifications about events.

## Database Setup

1. **Create the Database**: Run the following SQL script to set up the MySQL database.

    ```sql
    CREATE DATABASE EventManagementDB;
    USE EventManagementDB;

    CREATE TABLE users (
        user_id INT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(100) NOT NULL,
        email VARCHAR(100) UNIQUE NOT NULL,
        role ENUM('Admin', 'EventOrganizer', 'Attendee') NOT NULL
    );

    CREATE TABLE events (
        event_id INT AUTO_INCREMENT PRIMARY KEY,
        title VARCHAR(100) NOT NULL,
        description TEXT,
        date DATE,
        time TIME,
        venue VARCHAR(100),
        status ENUM('Pending', 'Approved', 'Rejected') DEFAULT 'Pending'
    );

    CREATE TABLE tickets (
        ticket_id INT AUTO_INCREMENT PRIMARY KEY,
        event_id INT,
        price DECIMAL(10, 2) NOT NULL,
        quantity INT NOT NULL,
        FOREIGN KEY (event_id) REFERENCES events(event_id)
    );

    CREATE TABLE system_settings (
        setting_key VARCHAR(50) PRIMARY KEY,
        setting_value VARCHAR(100)
    );
    ```

## Getting Started

### Prerequisites
- **Java**: JDK 8 or higher
- **MySQL**: Installed and running
- **MySQL JDBC Driver**: [Download from here](https://dev.mysql.com/downloads/connector/j/)

### Installation

1. **Clone the Repository**
   ```bash
   git clone https://github.com/SanjayTiwari25/Online-EventManagement-System.git
   cd Online-EventManagement-System
