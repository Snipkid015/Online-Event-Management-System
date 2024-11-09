CREATE DATABASE EventDB;
USE EventDB;

-- User table to store participant and organizer details
CREATE TABLE User (
    UserID INT PRIMARY KEY,
    UserName VARCHAR(50),
    Password VARCHAR(255),  -- Store hashed passwords for security
    Email VARCHAR(50),
    UserType ENUM('Organizer', 'Participant')  -- Specifies if the user is an event organizer or participant
);

-- Event table to store event details
CREATE TABLE Event (
    EventID INT PRIMARY KEY,
    Title VARCHAR(100),
    Description TEXT,
    StartDate DATETIME,
    EndDate DATETIME,
    Location VARCHAR(100),
    OrganizerID INT,
    FOREIGN KEY (OrganizerID)
        REFERENCES User(UserID)
);

-- Registration table to track participants registered for events
CREATE TABLE Registration (
    RegistrationID INT PRIMARY KEY,
    EventID INT,
    UserID INT,
    RegistrationDate DATETIME,
    Status ENUM('Registered', 'Cancelled'),  -- Registration status
    FOREIGN KEY (EventID)
        REFERENCES Event(EventID),
    FOREIGN KEY (UserID)
        REFERENCES User(UserID)
);

-- Session table for tracking event sessions
CREATE TABLE Session (
    SessionID INT PRIMARY KEY,
    EventID INT,
    SessionTitle VARCHAR(100),
    StartTime DATETIME,
    EndTime DATETIME,
    Speaker VARCHAR(50),
    FOREIGN KEY (EventID)
        REFERENCES Event(EventID)
);

-- Ticket table to store ticket details for paid events
CREATE TABLE Ticket (
    TicketID INT PRIMARY KEY,
    EventID INT,
    TicketType VARCHAR(50),  -- E.g., General, VIP
    Price DECIMAL(10, 2),  -- Price of the ticket
    QuantityAvailable INT,
    FOREIGN KEY (EventID)
        REFERENCES Event(EventID)
);

-- Payment table to store payment records
CREATE TABLE Payment (
    PaymentID INT PRIMARY KEY,
    RegistrationID INT,
    Amount DECIMAL(10, 2),
    PaymentDate DATETIME,
    PaymentStatus ENUM('Paid', 'Pending', 'Cancelled'),
    FOREIGN KEY (RegistrationID)
        REFERENCES Registration(RegistrationID)
);

-- Category table to categorize events (e.g., Conference, Workshop)
CREATE TABLE Category (
    CategoryID INT PRIMARY KEY,
    CategoryName VARCHAR(50)
);

-- EventCategory table to link events with multiple categories (many-to-many relationship)
CREATE TABLE EventCategory (
    EventID INT,
    CategoryID INT,
    PRIMARY KEY (EventID, CategoryID),
    FOREIGN KEY (EventID)
        REFERENCES Event(EventID),
    FOREIGN KEY (CategoryID)
        REFERENCES Category(CategoryID)
);

-- Feedback table to collect participant feedback on events
CREATE TABLE Feedback (
    FeedbackID INT PRIMARY KEY,
    EventID INT,
    UserID INT,
    Rating INT CHECK (Rating BETWEEN 1 AND 5),  -- Rating on a 1-5 scale
    Comments TEXT,
    FeedbackDate DATETIME,
    FOREIGN KEY (EventID)
        REFERENCES Event(EventID),
    FOREIGN KEY (UserID)
        REFERENCES User(UserID)
);
