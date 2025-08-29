import java.util.Scanner;
import java.util.Vector;

/**
 * Star Platinum task manager application.
 * A JoJo's Bizarre Adventure themed todo list manager.
 */
public class StarPlatinum {
    /**
     * Represents a task with a description and completion status.
     */
    public static class Task {
        protected String description;
        protected boolean isDone;

        /**
         * Creates a new task with the given description.
         * The task is initially marked as not done.
         *
         * @param description The description of the task.
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
            return (isDone ? "[X]" : "[ ]") + description;
        }
    }

    /**
     * Main method that runs the Star Platinum task manager.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        String logo = "      _                     _       _   _                       \r\n"
                + "  ___| |_ __ _ _ __   _ __ | | __ _| |_(_)_ __  _   _ _ __ ___  \r\n"
                + " / __| __/ _` | '__| | '_ \\| |/ _` | __| | '_ \\| | | | '_ ` _ \\ \r\n"
                + " \\__ \\ || (_| | |    | |_) | | (_| | |_| | | | | |_| | | | | | |\r\n"
                + " |___/\\__\\__,_|_|    | .__/|_|\\__,_|\\__|_|_| |_|\\__,_|_| |_| |_|\r\n"
                + "                     |_|                                        ";

        System.out.println("Hello from\n" + logo);

        String greeting = "____________________________________________________________\n"
                + " ORA ORA ORA ORA ORA!\n"
                + " Star Platinum is here, what can I do for you?\n"
                + "____________________________________________________________";

        String farewell = "____________________________________________________________\n"
                + " Yare Yare Daze... Star Platinum will see you again.\n"
                + "____________________________________________________________";

        System.out.println(greeting + "\n");

        Vector<Task> storage = new Vector<>();
        Scanner scanner = new Scanner(System.in);

        String userInput = "";
        while (!userInput.equals("bye")) {
            userInput = scanner.nextLine();
            String[] parts = userInput.split(" ");
            String command = parts[0];
            int taskNumber = -1;

            if ((command.equals("mark") || command.equals("unmark")) && parts.length >= 2) {
                taskNumber = Integer.parseInt(parts[1]);
            }

            if (command.equals("list")) {
                int i = 0;
                System.out.println("Zaaaa Woruuudo");
                while (i < storage.size()) {
                    System.out.println((i + 1) + "." + storage.get(i));
                    i++;
                }
                System.out.println('\n');
            } else if (command.equals("mark") || command.equals("unmark")) {
                if (parts.length < 2) {
                    System.out.println("Which task number would you like to " + command + "?");

                    // Display task list
                    int i = 0;
                    System.out.println("Zaaaa Woruuudo");
                    while (i < storage.size()) {
                        System.out.println((i + 1) + "." + storage.get(i));
                        i++;
                    }
                    System.out.println('\n');

                    // Get task number from user
                    boolean isValid = false;
                    while (!isValid) {
                        System.out.println("Please enter a valid task number:");

                        if (scanner.hasNextInt()) {
                            taskNumber = scanner.nextInt();
                            scanner.nextLine(); // consume leftover newline

                            if (taskNumber >= 1 && taskNumber <= storage.size()) {
                                isValid = true;
                            } else {
                                System.out.println("Number out of range!");
                            }
                        } else {
                            System.out.println("That's not a number!");
                            scanner.nextLine(); // consume the invalid input
                        }
                    }
                }

                if (taskNumber > 0 && taskNumber <= storage.size()) {
                    if (command.equals("mark")) {
                        storage.get(taskNumber - 1).mark();
                        System.out.println("Marked task: " + storage.get(taskNumber - 1));
                    } else {
                        storage.get(taskNumber - 1).unmark();
                        System.out.println("Unmarked task: " + storage.get(taskNumber - 1));
                    }
                } else {
                    System.out.println("Invalid task number.");
                }
                System.out.println('\n');
            } else if (!command.equals("bye") && taskNumber == -1) {
                storage.add(new Task(userInput));
                System.out.println("added: " + storage.lastElement() + "\n");
            }
        }

        scanner.close();
        System.out.println(farewell);
    }
}