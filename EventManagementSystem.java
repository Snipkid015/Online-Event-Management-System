import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// User class
class User {
    private int userId;
    private String userName;
    private String email;
    private String userType;

    public User(int userId, String userName, String email, String userType) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.userType = userType;
    }

    public int getUserId() { return userId; }
    public String getUserName() { return userName; }
    public String getEmail() { return email; }
    public String getUserType() { return userType; }
}

// Event class
class Event {
    private int eventId;
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private String location;
    private User organizer;
    private List<Session> sessions;

    public Event(int eventId, String title, String description, Date startDate, Date endDate, String location, User organizer) {
        this.eventId = eventId;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.organizer = organizer;
        this.sessions = new ArrayList<>();
    }

    public void addSession(Session session) {
        sessions.add(session);
    }

    public int getEventId() { return eventId; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public Date getStartDate() { return startDate; }
    public Date getEndDate() { return endDate; }
    public String getLocation() { return location; }
    public User getOrganizer() { return organizer; }
    public List<Session> getSessions() { return sessions; }
}

// Session class
class Session {
    private int sessionId;
    private String title;
    private Date startTime;
    private Date endTime;
    private String speaker;

    public Session(int sessionId, String title, Date startTime, Date endTime, String speaker) {
        this.sessionId = sessionId;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.speaker = speaker;
    }

    public int getSessionId() { return sessionId; }
    public String getTitle() { return title; }
    public Date getStartTime() { return startTime; }
    public Date getEndTime() { return endTime; }
    public String getSpeaker() { return speaker; }
}

// Registration class
class Registration {
    private int registrationId;
    private Event event;
    private User user;
    private Date registrationDate;
    private String status;

    public Registration(int registrationId, Event event, User user, Date registrationDate, String status) {
        this.registrationId = registrationId;
        this.event = event;
        this.user = user;
        this.registrationDate = registrationDate;
        this.status = status;
    }

    public int getRegistrationId() { return registrationId; }
    public Event getEvent() { return event; }
    public User getUser() { return user; }
    public Date getRegistrationDate() { return registrationDate; }
    public String getStatus() { return status; }
}

// Ticket class
class Ticket {
    private int ticketId;
    private Event event;
    private String ticketType;
    private double price;
    private int quantityAvailable;

    public Ticket(int ticketId, Event event, String ticketType, double price, int quantityAvailable) {
        this.ticketId = ticketId;
        this.event = event;
        this.ticketType = ticketType;
        this.price = price;
        this.quantityAvailable = quantityAvailable;
    }

    public int getTicketId() { return ticketId; }
    public Event getEvent() { return event; }
    public String getTicketType() { return ticketType; }
    public double getPrice() { return price; }
    public int getQuantityAvailable() { return quantityAvailable; }
}

// Payment class
class Payment {
    private int paymentId;
    private Registration registration;
    private double amount;
    private Date paymentDate;
    private String paymentStatus;

    public Payment(int paymentId, Registration registration, double amount, Date paymentDate, String paymentStatus) {
        this.paymentId = paymentId;
        this.registration = registration;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentStatus = paymentStatus;
    }

    public int getPaymentId() { return paymentId; }
    public Registration getRegistration() { return registration; }
    public double getAmount() { return amount; }
    public Date getPaymentDate() { return paymentDate; }
    public String getPaymentStatus() { return paymentStatus; }
}

// Feedback class
class Feedback {
    private int feedbackId;
    private Event event;
    private User user;
    private int rating;
    private String comments;
    private Date feedbackDate;

    public Feedback(int feedbackId, Event event, User user, int rating, String comments, Date feedbackDate) {
        this.feedbackId = feedbackId;
        this.event = event;
        this.user = user;
        this.rating = rating;
        this.comments = comments;
        this.feedbackDate = feedbackDate;
    }

    public int getFeedbackId() { return feedbackId; }
    public Event getEvent() { return event; }
    public User getUser() { return user; }
    public int getRating() { return rating; }
    public String getComments() { return comments; }
    public Date getFeedbackDate() { return feedbackDate; }
}

// Main class
public class EventManagementSystem {
    private List<User> users = new ArrayList<>();
    private List<Event> events = new ArrayList<>();
    private List<Registration> registrations = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void registerUserToEvent(User user, Event event) {
        Registration registration = new Registration(registrations.size() + 1, event, user, new Date(), "Registered");
        registrations.add(registration);
        System.out.println("User " + user.getUserName() + " registered for event " + event.getTitle());
    }

    public static void main(String[] args) {
        EventManagementSystem system = new EventManagementSystem();

        // Creating some sample data
        User organizer = new User(1, "Alice", "alice@example.com", "Organizer");
        system.addUser(organizer);

        Event event = new Event(1, "Tech Conference", "Annual technology conference", new Date(), new Date(), "City Hall", organizer);
        system.addEvent(event);

        User participant = new User(2, "Bob", "bob@example.com", "Participant");
        system.addUser(participant);

        system.registerUserToEvent(participant, event);
    }
}
