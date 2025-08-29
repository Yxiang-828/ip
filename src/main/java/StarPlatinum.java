import java.util.Scanner;
import java.util.Vector;

public class StarPlatinum {
        public static class Task {
                protected String description;
                protected boolean isDone;

                public Task(String description) {
                        this.description = description;
                        isDone = false;
                }

                public void mark() {
                        this.isDone = true;
                }

                void unmark() {
                        this.isDone = false;
                }

                public String toString() {
                        return (isDone ? "[X]" : "[ ]") + description;
                }
        }

        public static void main(String[] args) {
                String logo = "      _                     _       _   _                       \r\n" + //
                                "  ___| |_ __ _ _ __   _ __ | | __ _| |_(_)_ __  _   _ _ __ ___  \r\n" + //
                                " / __| __/ _` | '__| | '_ \\| |/ _` | __| | '_ \\| | | | '_ ` _ \\ \r\n" + //
                                " \\__ \\ || (_| | |    | |_) | | (_| | |_| | | | | |_| | | | | | |\r\n" + //
                                " |___/\\__\\__,_|_|    | .__/|_|\\__,_|\\__|_|_| |_|\\__,_|_| |_| |_|\r\n" + //
                                "                     |_|                                        ";

                System.out.println("Hello from\n" + logo);

                String greeting = "____________________________________________________________\n" +
                                " ORA ORA ORA ORA ORA!\n" +
                                " Star Platinum is here, what can I do for you?\n" +
                                "____________________________________________________________";

                String farewell = "____________________________________________________________\n" +
                                " Yare Yare Daze... Star Platinum will see you again.\n" +
                                "____________________________________________________________";

                System.out.println(greeting + "\n");

                Vector<Task> storage = new Vector<>();

                Scanner scanner = new Scanner(System.in); // scans constantly;

                String userInput = "";
                while (!userInput.equals("bye")) {
                        userInput = scanner.nextLine(); // gets user input
                        String[] parts = userInput.split(" "); // ["mark", "2"]
                        String command = parts[0]; // "mark"
                        int taskNumber = -1; // default value

                        if ((command.equals("mark") || command.equals("unmark")) && parts.length >= 2) {
                                taskNumber = Integer.parseInt(parts[1]); // only now safe to parse
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
                                        // list
                                        int i = 0;
                                        System.out.println("Zaaaa Woruuudo");
                                        while (i < storage.size()) {
                                                System.out.println((i + 1) + "." + storage.get(i));
                                                i++;
                                        }
                                        System.out.println('\n');

                                        // get task number
                                        boolean valid = false;

                                        while (!valid) {
                                                System.out.println("Please enter a valid task number:");

                                                if (scanner.hasNextInt()) {
                                                        taskNumber = scanner.nextInt();
                                                        scanner.nextLine(); // consume leftover newline

                                                        if (taskNumber >= 1 && taskNumber <= storage.size()) {
                                                                valid = true; // success, exit loop
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
                scanner.close(); // close scanner
                System.out.println(farewell);
        }
}