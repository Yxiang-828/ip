package starplatinum.task;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Handles loading and saving tasks to/from a file.
 */
public class Storage {
    private final String filePath;

    /**
     * Creates a new Storage instance with the specified file path.
     *
     * @param filePath The path to the file for storing tasks.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Loads tasks from the file.
     *
     * @return ArrayList of tasks loaded from the file.
     * @throws StarPlatinumException If there's an error loading the tasks.
     */
    public ArrayList<Task> load() throws StarPlatinumException {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) {
            return tasks; // Return empty list if file doesn't exist
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" \\| ");
                if (parts.length >= 3) {
                    String type = parts[0];
                    boolean done = parts[1].equals("1");
                    String desc = parts[2];
                    Task task = null;

                    if (type.equals("T")) {
                        task = new ToDo(desc);
                    } else if (type.equals("D") && parts.length >= 4) {
                        try {
                            LocalDate date = LocalDate.parse(parts[3]);
                            task = new Deadline(desc, date);
                        } catch (Exception e) {
                            // Skip corrupted deadline entries with invalid dates
                            System.out.println("Warning: Skipping corrupted deadline: " + line);
                        }
                    } else if (type.equals("E") && parts.length >= 5) {
                        try {
                            LocalDate fromDate = LocalDate.parse(parts[3]);
                            LocalDate toDate = LocalDate.parse(parts[4]);
                            task = new Event(desc, fromDate, toDate);
                        } catch (Exception e) {
                            // Skip corrupted event entries with invalid dates
                            System.out.println("Warning: Skipping corrupted event: " + line);
                        }
                    }

                    if (task != null) {
                        if (done)
                            task.mark();
                        tasks.add(task);
                    }
                } else {
                    // Corrupted line - skip and warn
                    System.out.println("Warning: Skipping corrupted line: " + line);
                }
            }
        } catch (IOException e) {
            throw new StarPlatinumException("Error loading tasks from file: " + e.getMessage());
        }

        return tasks;
    }

    /**
     * Saves the tasks to the file.
     *
     * @param tasks The ArrayList of tasks to save.
     * @throws StarPlatinumException If there's an error saving the tasks.
     */
    public void save(ArrayList<Task> tasks) throws StarPlatinumException {
        try {
            // Create data directory if it doesn't exist
            File dataDir = new File("./data");
            if (!dataDir.exists()) {
                dataDir.mkdirs();
            }

            // Write tasks to file
            File file = new File(filePath);
            try (PrintWriter writer = new PrintWriter(file)) {
                for (Task task : tasks) {
                    writer.println(task.toSaveFormat());
                }
            }
        } catch (IOException e) {
            throw new StarPlatinumException("Error saving tasks to file: " + e.getMessage());
        }
    }
}
