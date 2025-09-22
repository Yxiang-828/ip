package starplatinum.task;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles all user interface interactions for the Star Platinum application.
 * Responsible for displaying messages, reading user input, and formatting
 * output.
 */
public class Ui {
    private static final String HORIZONTAL_LINE = "____________________________________________________________";
    private final Scanner scanner;

    /**
     * Creates a new Ui instance with a scanner for reading user input.
     */
    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Shows the welcome message when the application starts.
     */
    public void showWelcome() {
        String logo = "      _                     _       _   _                       \r\n"
                + "  ___| |_ __ _ _ __   _ __ | | __ _| |_(_)_ __  _   _ _ __ ___  \r\n"
                + " / __| __/ _` | '__| | '_ \\| |/ _` | __| | '_ \\| | | | '_ ` _ \\ \r\n"
                + " \\__ \\ || (_| | |    | |_) | | (_| | |_| | | | | |_| | | | | | |\r\n"
                + " |___/\\__\\__,_|_|    | .__/|_|\\__,_|\\__|_|_| |_|\\__,_|_| |_| |_|\r\n"
                + "                     |_|                                        ";

        System.out.println("Hello from\n" + logo);

        String greeting = HORIZONTAL_LINE + "\n"
                + "ORA ORA ORA ORA ORA!\n"
                + "Star Platinum is here, what can I do for you?\n"
                + HORIZONTAL_LINE;

        System.out.println(greeting + "\n");
    }

    /**
     * Shows the farewell message when the application exits.
     */
    public void showFarewell() {
        String farewell = HORIZONTAL_LINE + "\n"
                + "Yare Yare Daze... Star Platinum will see you again.\n"
                + HORIZONTAL_LINE;
        System.out.println(farewell);
    }

    /**
     * Shows the horizontal divider line.
     */
    public void showLine() {
        System.out.println(HORIZONTAL_LINE);
    }

    /**
     * Reads a command from the user.
     *
     * @return The user's input command.
     */
    public String readCommand() {
        return scanner.nextLine();
    }

    /**
     * Shows an error message.
     *
     * @param message The error message to display.
     */
    public void showError(String message) {
        System.out.println(HORIZONTAL_LINE);
        System.out.println("Error: " + message);
        System.out.println(HORIZONTAL_LINE);
    }

    /**
     * Shows a loading error message.
     */
    public void showLoadingError() {
        System.out.println("Warning: Could not load tasks from file. Starting with empty task list.");
    }

    /**
     * Shows the task list.
     *
     * @param tasks The TaskList to display.
     */
    public void showTaskList(TaskList tasks) {
        System.out.println(HORIZONTAL_LINE);
        if (tasks.isEmpty()) {
            System.out.println("Here are the tasks in your list:");
            System.out.println("Your list is empty! Time to add some tasks.");
        } else {
            System.out.println("Here are the tasks in your list:");
            for (int i = 0; i < tasks.size(); i++) {
                try {
                    System.out.println((i + 1) + "." + tasks.get(i));
                } catch (StarPlatinumException e) {
                    // This shouldn't happen since we're iterating within bounds
                    System.out.println((i + 1) + ". [Error displaying task]");
                }
            }
        }
        System.out.println(HORIZONTAL_LINE + "\n");
    }

    /**
     * Shows a message when a task is added.
     *
     * @param task  The task that was added.
     * @param tasks The TaskList containing all tasks.
     */
    public void showTaskAdded(Task task, TaskList tasks) {
        System.out.println(HORIZONTAL_LINE);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + tasks.size() + " task" +
                (tasks.size() == 1 ? "" : "s") + " in the list.");
        System.out.println(HORIZONTAL_LINE + "\n");
    }

    /**
     * Shows a message when a task is marked as done.
     *
     * @param task The task that was marked.
     */
    public void showTaskMarked(Task task) {
        System.out.println(HORIZONTAL_LINE);
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("  " + task);
        System.out.println(HORIZONTAL_LINE);
    }

    /**
     * Shows a message when a task is unmarked (marked as not done).
     *
     * @param task The task that was unmarked.
     */
    public void showTaskUnmarked(Task task) {
        System.out.println(HORIZONTAL_LINE);
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println("  " + task);
        System.out.println(HORIZONTAL_LINE);
    }

    /**
     * Shows a message when a task is deleted.
     *
     * @param task  The task that was deleted.
     * @param tasks The TaskList containing remaining tasks.
     */
    public void showTaskDeleted(Task task, TaskList tasks) {
        System.out.println(HORIZONTAL_LINE);
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + tasks.size() + " task" +
                (tasks.size() == 1 ? "" : "s") + " in the list.");
        System.out.println(HORIZONTAL_LINE);
    }

    /**
     * Shows an invalid task number message.
     */
    public void showInvalidTaskNumber() {
        System.out.println(HORIZONTAL_LINE);
        System.out.println("Invalid task number.");
        System.out.println(HORIZONTAL_LINE);
    }

    /**
     * Shows an empty command message.
     */
    public void showEmptyCommand() {
        System.out.println("Please enter a command. Type 'list' to see your tasks or 'bye' to exit.");
    }

    /**
     * Shows the results of a find command.
     *
     * @param foundTasks The list of tasks that match the search.
     * @param keyword    The search keyword that was used.
     */
    public void showFindResults(ArrayList<Task> foundTasks, String keyword) {
        System.out.println(HORIZONTAL_LINE);
        if (foundTasks.isEmpty()) {
            System.out.println("No tasks found containing '" + keyword + "'.");
        } else {
            System.out.println("Here are the matching tasks for '" + keyword + "':");
            for (int i = 0; i < foundTasks.size(); i++) {
                System.out.println((i + 1) + "." + foundTasks.get(i));
            }
        }
        System.out.println(HORIZONTAL_LINE + "\n");
    }

    /**
     * Closes the scanner.
     */
    public void close() {
        scanner.close();
    }
}