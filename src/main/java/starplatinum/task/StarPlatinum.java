package starplatinum.task;

/**
 * Star Platinum task manager application.
 * A JoJo's Bizarre Adventure themed todo list manager.
 */
public class StarPlatinum {

    private final Ui ui;
    private final Storage storage;
    private final TaskList tasks;

    /**
     * Creates a new Star Platinum application instance.
     *
     * @param filePath The path to the file for storing tasks.
     */
    public StarPlatinum(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        TaskList loadedTasks;
        try {
            loadedTasks = new TaskList(storage.load());
        } catch (StarPlatinumException e) {
            ui.showLoadingError();
            loadedTasks = new TaskList();
        }
        tasks = loadedTasks;
    }

    public void run() {
        ui.showWelcome();

        while (true) {
            String command = "";
            try {
                String input = ui.readCommand();
                ui.showLine();

                command = Parser.parseCommand(input);

                switch (command) {
                    case "bye":
                        ui.showFarewell();
                        ui.close();
                        return;

                    case "list":
                        ui.showTaskList(tasks);
                        break;

                    case "mark":
                        handleMarkCommand(input);
                        break;

                    case "unmark":
                        handleUnmarkCommand(input);
                        break;

                    case "todo":
                        handleTodoCommand(input);
                        break;

                    case "deadline":
                        handleDeadlineCommand(input);
                        break;

                    case "event":
                        handleEventCommand(input);
                        break;

                    case "delete":
                        handleDeleteCommand(input);
                        break;

                    default:
                        if (input.trim().isEmpty()) {
                            ui.showEmptyCommand();
                        } else {
                            handleTodoCommand("todo " + input);
                        }
                        break;
                }

                if (!command.equals("list") && !command.equals("bye")) {
                    storage.save(tasks.getAllTasks());
                }

            } catch (StarPlatinumException e) {
                ui.showError(e.getMessage());
            } finally {
                if (!command.equals("bye")) {
                    ui.showLine();
                }
            }
        }
    }

    /**
     * Handles the mark command.
     */
    private void handleMarkCommand(String input) throws StarPlatinumException {
        int taskNumber = Parser.parseTaskNumber(input);
        if (taskNumber == -1) {
            ui.showInvalidTaskNumber();
            return;
        }

        Task markedTask = tasks.mark(taskNumber - 1); // Convert to 0-based index
        ui.showTaskMarked(markedTask);
    }

    /**
     * Handles the unmark command.
     */
    private void handleUnmarkCommand(String input) throws StarPlatinumException {
        int taskNumber = Parser.parseTaskNumber(input);
        if (taskNumber == -1) {
            ui.showInvalidTaskNumber();
            return;
        }

        Task unmarkedTask = tasks.unmark(taskNumber - 1); // Convert to 0-based index
        ui.showTaskUnmarked(unmarkedTask);
    }

    /**
     * Handles the todo command.
     */
    private void handleTodoCommand(String input) throws StarPlatinumException {
        String description = Parser.parseTodoDescription(input);
        Task newTask = new ToDo(description);
        tasks.add(newTask);
        ui.showTaskAdded(newTask, tasks);
    }

    /**
     * Handles the deadline command.
     */
    private void handleDeadlineCommand(String input) throws StarPlatinumException {
        String[] deadlineInfo = Parser.parseDeadline(input);
        Task newTask = new Deadline(deadlineInfo[0], deadlineInfo[1]);
        tasks.add(newTask);
        ui.showTaskAdded(newTask, tasks);
    }

    /**
     * Handles the event command.
     */
    private void handleEventCommand(String input) throws StarPlatinumException {
        String[] eventInfo = Parser.parseEvent(input);
        Task newTask = new Event(eventInfo[0], eventInfo[1], eventInfo[2]);
        tasks.add(newTask);
        ui.showTaskAdded(newTask, tasks);
    }

    /**
     * Handles the delete command.
     */
    private void handleDeleteCommand(String input) throws StarPlatinumException {
        int taskNumber = Parser.parseTaskNumber(input);
        if (taskNumber == -1) {
            ui.showInvalidTaskNumber();
            return;
        }

        Task deletedTask = tasks.delete(taskNumber - 1); // Convert to 0-based index
        ui.showTaskDeleted(deletedTask, tasks);
    }

    /**
     * Main method that starts the Star Platinum task manager.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        new StarPlatinum("data/tasks.txt").run();
    }
}
