package starplatinum.task;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Deadline extends Task {
    protected LocalDate by;

    /**
     * Creates a new Deadline task.
     *
     * @param description The description of the task.
     * @param by          The deadline date/time as a LocalDate.
     */
    public Deadline(String description, LocalDate by) {
        super(description);
        this.by = by;
    }

    /**
     * Returns a string representation of the deadline task.
     * Shows [D] and includes the deadline information.
     *
     * @return String representation with deadline info.
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
        return "[D]" + (isDone ? "[X]" : "[ ]") + " " + description + " (by: " + by.format(formatter) + ")";
    }

    /**
     * Returns the deadline task data in save format.
     *
     * @return String representation for saving to file.
     */
    @Override
    public String toSaveFormat() {
        return "D | " + (isDone ? 1 : 0) + " | " + description + " | " + by.toString();
    }
}