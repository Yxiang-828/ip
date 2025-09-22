package starplatinum.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    protected LocalDate from;
    protected LocalDate to;

    /**
     * Creates a new Event task.
     *
     * @param description The description of the task.
     * @param from        The start date as a LocalDate.
     * @param to          The end date as a LocalDate.
     */
    public Event(String description, LocalDate from, LocalDate to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     * Returns a string representation of the event task.
     * Shows [E] and includes the start and end time information.
     *
     * @return String representation with event timing info.
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
        return "[E]" + (isDone ? "[X]" : "[ ]") + " " + description + " (from: " + from.format(formatter) + " to: " + to.format(formatter) + ")";
    }

    /**
     * Returns the event task data in save format.
     *
     * @return String representation for saving to file.
     */
    @Override
    public String toSaveFormat() {
        return "E | " + (isDone ? 1 : 0) + " | " + description + " | " + from.toString() + " | " + to.toString();
    }
}