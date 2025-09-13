package starplatinum.task;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Vector;
//level-7: merge practice
/**
 * Star Platinum task manager application.
 * A JoJo's Bizarre Adventure themed todo list manager.
 * Now supports ToDos, Deadlines, and Events!
 */
//level-6: merge practice
public class StarPlatinum {
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
                + "ORA ORA ORA ORA ORA!\n"
                + "Star Platinum is here, what can I do for you?\n"
                + "____________________________________________________________";

        String farewell = "____________________________________________________________\n"
                + "Yare Yare Daze... Star Platinum will see you again.\n"
                + "____________________________________________________________";

        System.out.println(greeting + "\n");

        Vector<Task> storage = new Vector<>();
        Scanner scanner = new Scanner(System.in);

        String userInput = "";
        while (!userInput.trim().equals("bye")) {
            try {
                userInput = scanner.nextLine();
            } catch (NoSuchElementException | IllegalStateException e) {
                // Catches if input stream is gone or scanner is closed
                System.out.println("Input error occurred. Exiting...");
                break;
            }

            // Check for empty or whitespace-only input
            if (userInput.trim().isEmpty()) {
                System.out.println("Please enter a command. Type 'list' to see your tasks or 'bye' to exit.");
                continue; // Skip to next iteration
            }

            String[] parts = userInput.split(" ");
            String command = parts[0];
            int taskNumber = -1;

            if ((command.equals("mark") || command.equals("unmark")) && parts.length >= 2) {
                try {
                    taskNumber = Integer.parseInt(parts[1]);
                } catch (NumberFormatException e) {
                    taskNumber = -1; // Invalid number
                }
            }

            if (command.equals("list")) {
                System.out.println("____________________________________________________________");
                if (storage.isEmpty()) {
                    System.out.println("Here are the tasks in your list:");
                    System.out.println("Your list is empty! Time to add some tasks.");
                } else {
                    System.out.println("Here are the tasks in your list:");
                    for (int i = 0; i < storage.size(); i++) {
                        System.out.println((i + 1) + "." + storage.get(i));
                    }
                }
                System.out.println("____________________________________________________________\n");
            } else if (command.equals("mark") || command.equals("unmark")) {
                if (parts.length < 2) {
                    System.out.println("Which task number would you like to " + command + "?");

                    // Display task list
                    System.out.println("____________________________________________________________");
                    System.out.println("Here are the tasks in your list:");
                    for (int i = 0; i < storage.size(); i++) {
                        System.out.println((i + 1) + "." + storage.get(i));
                    }
                    System.out.println("____________________________________________________________");

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
                        System.out.println("____________________________________________________________");
                        System.out.println("Nice! I've marked this task as done:");
                        System.out.println("  " + storage.get(taskNumber - 1));
                        System.out.println("____________________________________________________________");
                    } else {
                        storage.get(taskNumber - 1).unmark();
                        System.out.println("____________________________________________________________");
                        System.out.println("OK, I've marked this task as not done yet:");
                        System.out.println("  " + storage.get(taskNumber - 1));
                        System.out.println("____________________________________________________________");
                    }
                } else {
                    System.out.println("____________________________________________________________");
                    System.out.println("Invalid task number.");
                    System.out.println("____________________________________________________________");
                }
                System.out.println();
            } else if (command.equals("todo") && parts.length > 1) {
                // Handle "todo DESCRIPTION"
                try {
                    if (userInput.length() <= 5) {
                        System.out.println("____________________________________________________________");
                        System.out.println("Invalid todo format! Use: todo DESCRIPTION");
                        System.out.println("____________________________________________________________\n");
                    } else {
                        String description = userInput.substring(5).trim();
                        if (description.isEmpty()) {
                            System.out.println("____________________________________________________________");
                            System.out.println("Todo description cannot be empty! Use: todo DESCRIPTION");
                            System.out.println("____________________________________________________________\n");
                        } else {
                            Task newTask = new ToDo(description);
                            storage.add(newTask);
                            System.out.println("____________________________________________________________");
                            System.out.println("Got it. I've added this task:");
                            System.out.println("  " + newTask);
                            System.out.println("Now you have " + storage.size() + " task" +
                                    (storage.size() == 1 ? "" : "s") + " in the list.");
                            System.out.println("____________________________________________________________\n");
                        }
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("____________________________________________________________");
                    System.out.println("Invalid todo format! Use: todo DESCRIPTION");
                    System.out.println("____________________________________________________________\n");
                }
            } else if (command.equals("deadline")) {
                // Handle "deadline DESCRIPTION /by DATE"
                try {
                    if (userInput.length() <= 9) {
                        System.out.println("____________________________________________________________");
                        System.out.println("Invalid deadline format! Use: deadline DESCRIPTION /by DATE");
                        System.out.println("____________________________________________________________\n");
                    } else {
                        String remaining = userInput.substring(9); // Remove "deadline "
                        String[] byParts = remaining.split(" /by ", 2);

                        if (byParts.length == 2 && !byParts[0].trim().isEmpty() && !byParts[1].trim().isEmpty()) {
                            Task newTask = new Deadline(byParts[0].trim(), byParts[1].trim());
                            storage.add(newTask);
                            System.out.println("____________________________________________________________");
                            System.out.println("Got it. I've added this task:");
                            System.out.println("  " + newTask);
                            System.out.println("Now you have " + storage.size() + " task" +
                                    (storage.size() == 1 ? "" : "s") + " in the list.");
                            System.out.println("____________________________________________________________\n");
                        } else {
                            System.out.println("____________________________________________________________");
                            System.out.println("Invalid deadline format! Use: deadline DESCRIPTION /by DATE");
                            System.out.println("____________________________________________________________\n");
                        }
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("____________________________________________________________");
                    System.out.println("Invalid deadline format! Use: deadline DESCRIPTION /by DATE");
                    System.out.println("____________________________________________________________\n");
                }
            } else if (command.equals("event")) {
                // Handle "event DESCRIPTION /from START /to END"
                try {
                    if (userInput.length() <= 6) {
                        System.out.println("____________________________________________________________");
                        System.out.println("Invalid event format! Use: event DESCRIPTION /from START /to END");
                        System.out.println("____________________________________________________________\n");
                    } else {
                        String remaining = userInput.substring(6); // Remove "event "
                        String[] fromParts = remaining.split(" /from ", 2);

                        if (fromParts.length == 2) {
                            String description = fromParts[0].trim();
                            String[] toParts = fromParts[1].split(" /to ", 2);

                            if (toParts.length == 2 && !description.isEmpty() &&
                                    !toParts[0].trim().isEmpty() && !toParts[1].trim().isEmpty()) {
                                Task newTask = new Event(description, toParts[0].trim(), toParts[1].trim());
                                storage.add(newTask);
                                System.out.println("____________________________________________________________");
                                System.out.println("Got it. I've added this task:");
                                System.out.println("  " + newTask);
                                System.out.println("Now you have " + storage.size() + " task" +
                                        (storage.size() == 1 ? "" : "s") + " in the list.");
                                System.out.println("____________________________________________________________\n");
                            } else {
                                System.out.println("____________________________________________________________");
                                System.out.println("Invalid event format! Use: event DESCRIPTION /from START /to END");
                                System.out.println("____________________________________________________________\n");
                            }
                        } else {
                            System.out.println("____________________________________________________________");
                            System.out.println("Invalid event format! Use: event DESCRIPTION /from START /to END");
                            System.out.println("____________________________________________________________\n");
                        }
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("____________________________________________________________");
                    System.out.println("Invalid event format! Use: event DESCRIPTION /from START /to END");
                    System.out.println("____________________________________________________________\n");
                }
            } else if (!userInput.trim().equals("bye") && taskNumber == -1) {
                // Treat as plain ToDo for backward compatibility
                Task newTask = new ToDo(userInput);
                storage.add(newTask);
                System.out.println("____________________________________________________________");
                System.out.println("Got it. I've added this task:");
                System.out.println("  " + newTask);
                System.out.println("Now you have " + storage.size() + " task" +
                        (storage.size() == 1 ? "" : "s") + " in the list.");
                System.out.println("____________________________________________________________\n");
            }
        }

        scanner.close();
        System.out.println(farewell);
    }
}
