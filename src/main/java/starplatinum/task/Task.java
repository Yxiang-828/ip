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
     * Returns the task description.
     *
     * @return The description of the task.
     */
    public String getDescription() {
        return description;
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

    /**
     * Returns the task data in save format.
     * Format: TYPE | DONE_STATUS | DESCRIPTION | [ADDITIONAL_FIELDS]
     *
     * @return String representation for saving to file.
     */
    public String toSaveFormat() {
        return "T | " + (isDone ? 1 : 0) + " | " + description;
    }
}