package starplatinum.task;
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Creates a new task with the given description.
     * The task is initially marked as not done.
     *
     * @param description Task description.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Marks the task as completed.
     */
    public void mark() {
        this.isDone = true;
    }

    /**
     * Marks the task as not completed.
     */
    public void unmark() {
        this.isDone = false;
    }

    /**
     * Returns a string representation of the task.
     * Completed tasks are shown with [X], incomplete tasks with [ ].
     *
     * @return String representation of the task.
     */
    public String toString() {
        return (isDone ? "[X]" : "[ ]") + " " + description;
    }
}