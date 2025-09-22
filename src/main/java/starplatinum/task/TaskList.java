package starplatinum.task;

import java.util.ArrayList;

/**
 * Manages a collection of tasks, providing operations to add, delete, mark, and
 * unmark tasks.
 */
public class TaskList {
    private final ArrayList<Task> tasks;

    /**
     * Creates an empty TaskList.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Creates a TaskList with the given tasks.
     *
     * @param tasks The initial list of tasks.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = new ArrayList<>(tasks);
    }

    /**
     * Adds a task to the list.
     *
     * @param task The task to add.
     */
    public void add(Task task) {
        tasks.add(task);
    }

    /**
     * Deletes a task from the list by its index.
     *
     * @param index The 0-based index of the task to delete.
     * @return The deleted task.
     * @throws StarPlatinumException If the index is invalid.
     */
    public Task delete(int index) throws StarPlatinumException {
        if (index < 0 || index >= tasks.size()) {
            throw new StarPlatinumException("Invalid task number: " + (index + 1));
        }
        return tasks.remove(index);
    }

    /**
     * Marks a task as done by its index.
     *
     * @param index The 0-based index of the task to mark.
     * @return The marked task.
     * @throws StarPlatinumException If the index is invalid.
     */
    public Task mark(int index) throws StarPlatinumException {
        if (index < 0 || index >= tasks.size()) {
            throw new StarPlatinumException("Invalid task number: " + (index + 1));
        }
        Task task = tasks.get(index);
        task.mark();
        return task;
    }

    /**
     * Unmarks a task (marks as not done) by its index.
     *
     * @param index The 0-based index of the task to unmark.
     * @return The unmarked task.
     * @throws StarPlatinumException If the index is invalid.
     */
    public Task unmark(int index) throws StarPlatinumException {
        if (index < 0 || index >= tasks.size()) {
            throw new StarPlatinumException("Invalid task number: " + (index + 1));
        }
        Task task = tasks.get(index);
        task.unmark();
        return task;
    }

    /**
     * Gets a task by its index.
     *
     * @param index The 0-based index of the task.
     * @return The task at the specified index.
     * @throws StarPlatinumException If the index is invalid.
     */
    public Task get(int index) throws StarPlatinumException {
        if (index < 0 || index >= tasks.size()) {
            throw new StarPlatinumException("Invalid task number: " + (index + 1));
        }
        return tasks.get(index);
    }

    /**
     * Returns the number of tasks in the list.
     *
     * @return The size of the task list.
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Checks if the task list is empty.
     *
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    /**
     * Returns the underlying ArrayList of tasks.
     * This is used for saving tasks to file.
     *
     * @return The ArrayList containing all tasks.
     */
    public ArrayList<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    /**
     * Finds tasks that contain the specified keyword in their description.
     *
     * @param keyword The keyword to search for (case-insensitive).
     * @return ArrayList of tasks that match the search.
     */
    public ArrayList<Task> findTasks(String keyword) {
        ArrayList<Task> matchingTasks = new ArrayList<>();
        String lowerKeyword = keyword.toLowerCase();

        for (Task task : tasks) {
            if (task.getDescription().toLowerCase().contains(lowerKeyword)) {
                matchingTasks.add(task);
            }
        }

        return matchingTasks;
    }
}