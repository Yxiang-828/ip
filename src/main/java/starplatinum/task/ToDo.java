package starplatinum.task;
public class ToDo extends Task {

    /**
     * Creates a new ToDo task.
     *
     * @param description Task description.
     */
    public ToDo(String description) {
        super(description);
    }

    /**
     * Returns a string representation of the ToDo task.
     * Shows [T] to indicate this is a ToDo task.
     *
     * @return String representation with ToDo task indicator.
     */
    @Override
    public String toString() {
        return "[T]" + (isDone ? "[X]" : "[ ]") + " " + description;
    }
}