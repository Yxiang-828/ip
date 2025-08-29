import java.util.Scanner;
import java.util.Vector;

public class StarPlatinum {
        public static void main(String[] args) {
                String logo = "      _                     _       _   _                       \r\n" + //
                                "  ___| |_ __ _ _ __   _ __ | | __ _| |_(_)_ __  _   _ _ __ ___  \r\n" + //
                                " / __| __/ _` | '__| | '_ \\| |/ _` | __| | '_ \\| | | | '_ ` _ \\ \r\n" + //
                                " \\__ \\ || (_| | |    | |_) | | (_| | |_| | | | | |_| | | | | | |\r\n" + //
                                " |___/\\__\\__,_|_|    | .__/|_|\\__,_|\\__|_|_| |_|\\__,_|_| |_| |_|\r\n" + //
                                "                     |_|                                        ";

                System.out.println("Hello from\n" + logo);

                String greeting = "____________________________________________________________\n" +
                                "ORA ORA ORA ORA ORA!\n" +
                                "Star Platinum is here, what can I do for you?\n" +
                                "____________________________________________________________";

                String farewell = "____________________________________________________________\n" +
                                "Yare Yare Daze... Star Platinum will see you again.\n" +
                                "____________________________________________________________";

                System.out.println(greeting + "\n");

                Vector<String> tasks = new Vector<>();
                Scanner scanner = new Scanner(System.in);

                String userInput = "";
                while (!userInput.equals("bye")) {
                        userInput = scanner.nextLine();

                        if (userInput.equals("list")) {
                                System.out.println("____________________________________________________________");
                                if (tasks.isEmpty()) {
                                        System.out.println("Your task list is empty!");
                                } else {
                                        for (int i = 0; i < tasks.size(); i++) {
                                                System.out.println(" " + (i + 1) + ". " + tasks.get(i));
                                        }
                                }
                                System.out.println("____________________________________________________________\n");
                        } else if (!userInput.equals("bye")) {
                                tasks.add(userInput);
                                System.out.println("____________________________________________________________");
                                System.out.println("added: " + userInput);
                                System.out.println("____________________________________________________________\n");
                        }
                }

                scanner.close();
                System.out.println(farewell);
        }
}