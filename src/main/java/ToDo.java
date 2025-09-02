public class ToDo extends Task {

    /**
     * Creates a new ToDo task.
     *
     * @param description
     */
    public ToDo(String description) {
        super(description);
    }

    /**
     * Returns a string representation of the ToDo task.
     * Shows [T] to indicate this is a ToDo task.
     *
     * @return
     */
    @Override
    public String toString() {
        return "[T]" + (isDone ? "[X]" : "[ ]") + " " + description;
    }
}