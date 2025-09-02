/**
 * Example: "submit report by 11/10/2019 5pm"
 */
public class Deadline extends Task {
    protected String by;

    /**
     * @param description The description of the task.
     * @param by The deadline date/time as a string.
     */
    public Deadline(String description, String by) {
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
        return "[D]" + (isDone ? "[X]" : "[ ]") + " " + description + " (by: " + by + ")";
    }
}