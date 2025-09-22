package starplatinum.task;

public class Deadline extends Task {
    protected String by;

    /**
     * Creates a new Deadline task.
     *
     * @param description The description of the task.
     * @param by          The deadline date/time as a string.
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

    /**
     * Returns the deadline task data in save format.
     *
     * @return String representation for saving to file.
     */
    @Override
    public String toSaveFormat() {
        return "D | " + (isDone ? 1 : 0) + " | " + description + " | " + by;
    }
}