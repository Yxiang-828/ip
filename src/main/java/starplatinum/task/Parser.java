package starplatinum.task;

/**
 * Parses user input commands and extracts relevant information.
 */
public class Parser {

    /**
     * Parses the command from user input.
     *
     * @param input The user's input string.
     * @return The command type.
     */
    public static String parseCommand(String input) {
        if (input.trim().isEmpty()) {
            return "";
        }
        String[] parts = input.trim().split("\\s+", 2);
        return parts[0].toLowerCase();
    }

    /**
     * Parses a task number from the input (for mark, unmark, delete commands).
     *
     * @param input The user's input string.
     * @return The task number (1-based), or -1 if invalid.
     */
    public static int parseTaskNumber(String input) {
        String[] parts = input.trim().split("\\s+", 2);
        if (parts.length >= 2) {
            try {
                return Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                return -1;
            }
        }
        return -1;
    }

    /**
     * Parses a todo description from the input.
     *
     * @param input The user's input string.
     * @return The todo description.
     * @throws StarPlatinumException If the format is invalid.
     */
    public static String parseTodoDescription(String input) throws StarPlatinumException {
        if (input.length() <= 4) {
            throw new StarPlatinumException("Invalid todo format! Use: todo DESCRIPTION");
        }
        String description = input.substring(4).trim();
        if (description.isEmpty()) {
            throw new StarPlatinumException("Todo description cannot be empty! Use: todo DESCRIPTION");
        }
        return description;
    }

    /**
     * Parses deadline information from the input.
     *
     * @param input The user's input string.
     * @return A String array containing [description, byDate].
     * @throws StarPlatinumException If the format is invalid.
     */
    public static String[] parseDeadline(String input) throws StarPlatinumException {
        if (input.length() <= 8) {
            throw new StarPlatinumException("Invalid deadline format! Use: deadline DESCRIPTION /by DATE");
        }
        String remaining = input.substring(8).trim(); // Remove "deadline"
        String[] byParts = remaining.split(" /by ", 2);

        if (byParts.length != 2 || byParts[0].trim().isEmpty() || byParts[1].trim().isEmpty()) {
            throw new StarPlatinumException("Invalid deadline format! Use: deadline DESCRIPTION /by DATE");
        }

        return new String[] { byParts[0].trim(), byParts[1].trim() };
    }

    /**
     * Parses event information from the input.
     *
     * @param input The user's input string.
     * @return A String array containing [description, fromTime, toTime].
     * @throws StarPlatinumException If the format is invalid.
     */
    public static String[] parseEvent(String input) throws StarPlatinumException {
        if (input.length() <= 5) {
            throw new StarPlatinumException("Invalid event format! Use: event DESCRIPTION /from START /to END");
        }
        String remaining = input.substring(5).trim(); // Remove "event "
        String[] fromParts = remaining.split(" /from ", 2);

        if (fromParts.length != 2) {
            throw new StarPlatinumException("Invalid event format! Use: event DESCRIPTION /from START /to END");
        }

        String description = fromParts[0].trim();
        String[] toParts = fromParts[1].split(" /to ", 2);

        if (toParts.length != 2 || description.isEmpty() ||
                toParts[0].trim().isEmpty() || toParts[1].trim().isEmpty()) {
            throw new StarPlatinumException("Invalid event format! Use: event DESCRIPTION /from START /to END");
        }

        return new String[] { description, toParts[0].trim(), toParts[1].trim() };
    }
}