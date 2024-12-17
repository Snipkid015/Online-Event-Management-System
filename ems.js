document.getElementById("event-form").addEventListener("submit", function (event) {
    event.preventDefault();

    // Get and validate event name and date
    const eventName = document.getElementById("event-name").value.trim();
    const eventDate = document.getElementById("event-date").value;

    // Reference to the upcoming events list
    const upcomingEventsList = document.getElementById("upcoming-events");

    // Validate that the name and date fields are filled
    if (!eventName || !eventDate) {
        alert("Please fill out both the event name and date!");
        return;
    }

    // Parse the date to check if it's valid and not in the past
    const selectedDate = new Date(eventDate);
    const currentDate = new Date();

    if (selectedDate < currentDate) {
        alert("Event date cannot be in the past. Please select a valid date.");
        return;
    }

    // Create a new list item for the upcoming event
    const newEventItem = document.createElement("li");
    newEventItem.textContent = `${eventName} - ${selectedDate.toLocaleDateString('en-IN', {
        day: 'numeric',
        month: 'long',
        year: 'numeric'
    })}`;

    // Append the new event to the upcoming events list
    upcomingEventsList.appendChild(newEventItem);

    // Display success message
    alert(`Event "${eventName}" scheduled successfully for ${selectedDate.toLocaleDateString('en-IN', {
        day: 'numeric',
        month: 'long',
        year: 'numeric'
    })}.`);

    // Reset the form fields
    document.getElementById("event-name").value = "";
    document.getElementById("event-date").value = "";
});
