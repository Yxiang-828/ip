package starplatinum.task;
/**
 * Example: "team project meeting 2/10/2019 2-4pm"
 */
public class Event extends Task {
    protected String from;
    protected String to;

    /**
     * Creates a new Event task.
     *
     * @param description The description of the task.
     * @param from The start date/time as a string.
     * @param to The end date/time as a string.
     */
    public Event(String description, String from, String to) {
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
        return "[E]" + (isDone ? "[X]" : "[ ]") + " " + description + " (from: " + from + " to: " + to + ")";
    }

    /**
     * Returns the event task data in save format.
     *
     * @return String representation for saving to file.
     */
    @Override
    public String toSaveFormat() {
        return "E | " + (isDone ? 1 : 0) + " | " + description + " | " + from + " | " + to;
    }
}