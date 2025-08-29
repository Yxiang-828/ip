
import java.util.Scanner;

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
                                "Star Platinum is here — what can I do for you?\n" +
                                "____________________________________________________________";

                String farewell = "____________________________________________________________\n" +
                                "Yare Yare Daze... Star Platinum will see you again.\n" +
                                "____________________________________________________________";

                System.out.println(greeting + "\n");

                Scanner scanner = new Scanner(System.in);

                String userInput = "";
                while (!userInput.equals("bye")) {
                        userInput = scanner.nextLine();

                        if (!userInput.equals("bye")) {
                                System.out.println("____________________________________________________________");
                                System.out.println(userInput);
                                System.out.println("____________________________________________________________\n");
                        }
                }

                scanner.close();
                System.out.println(farewell);
        }
}