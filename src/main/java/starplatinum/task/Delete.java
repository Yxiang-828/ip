package starplatinum.task;

import java.util.ArrayList;

public class Delete {
    private int taskNumber;

    public Delete(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    public int getTaskNumber() {
        return taskNumber;
    }

    /**
     * Executes the delete command by removing the task from the storage.
     *
     * @param storage The arraylist containing all tasks.
     * @return true if the task was successfully deleted, false otherwise.
     */
    public boolean execute(ArrayList<Task> storage) {
        if (taskNumber >= 1 && taskNumber <= storage.size()) {
            Task removedTask = storage.remove(taskNumber - 1);
            System.out.println("____________________________________________________________");
            System.out.println("Noted. I've removed this task:");
            System.out.println("  " + removedTask);
            System.out.println("Now you have " + storage.size() + " task" +
                    (storage.size() == 1 ? "" : "s") + " in the list.");
            System.out.println("____________________________________________________________");
            return true;
        } else {
            System.out.println("____________________________________________________________");
            System.out.println("Invalid task number. Cannot delete.");
            System.out.println("____________________________________________________________");
            return false;
        }
    }
}
