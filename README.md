# Star Platinum User Guide

![Star Platinum Logo](docs/images/jojo.jpg)

**Star Platinum** is a **JoJo's Bizarre Adventure themed task management chatbot** designed to help you organize and track your tasks efficiently. With the power of Star Platinum's time-stopping abilities, manage your todos, deadlines, and events with lightning speed!

## Table of Contents
- [Star Platinum User Guide](#star-platinum-user-guide)
  - [Table of Contents](#table-of-contents)
  - [Quick Start](#quick-start)
  - [Features](#features)
    - [Adding a Todo Task](#adding-a-todo-task)
    - [Adding a Deadline Task](#adding-a-deadline-task)
    - [Adding an Event Task](#adding-an-event-task)
    - [Listing All Tasks](#listing-all-tasks)
    - [Marking Tasks as Done](#marking-tasks-as-done)
    - [Unmarking Tasks](#unmarking-tasks)
    - [Deleting Tasks](#deleting-tasks)
    - [Finding Tasks](#finding-tasks)
    - [Exiting the Application](#exiting-the-application)
  - [Command Summary](#command-summary)
  - [FAQ](#faq)

## Quick Start

1. Ensure you have Java 17 or above installed on your computer.
2. Download the latest `StarPlatinum.jar` from the [releases page](https://github.com/Yxiang-828/ip/releases).
3. Copy the jar file to an empty folder (this will be your home folder for Star Platinum).
4. Open a command terminal and navigate to the folder containing the jar file.
5. Run the application using: `java -jar StarPlatinum.jar`
6. Start managing your tasks with Star Platinum's time-stopping efficiency!

## Features

### Adding a Todo Task

Creates a simple task without any time constraints.

**Command Format:** `todo DESCRIPTION`

**Example:**
```
todo Buy groceries
```

**Expected Output:**
```
____________________________________________________________
Got it. I've added this task:
  [T][ ] Buy groceries
Now you have 1 task in the list.
____________________________________________________________
```

### Adding a Deadline Task

Creates a task that must be completed by a specific date.

**Command Format:** `deadline DESCRIPTION /by yyyy-MM-dd`

**Example:**
```
deadline Submit assignment /by 2025-09-30
```

**Expected Output:**
```
____________________________________________________________
Got it. I've added this task:
  [D][ ] Submit assignment (by: Sep 30 2025)
Now you have 2 tasks in the list.
____________________________________________________________
```

### Adding an Event Task

Creates a task that occurs over a time period with a start and end date.

**Command Format:** `event DESCRIPTION /from yyyy-MM-dd /to yyyy-MM-dd`

**Example:**
```
event Team meeting /from 2025-10-01 /to 2025-10-01
```

**Expected Output:**
```
____________________________________________________________
Got it. I've added this task:
  [E][ ] Team meeting (from: Oct 01 2025 to: Oct 01 2025)
Now you have 3 tasks in the list.
____________________________________________________________
```

**Note:** The start date cannot be after the end date. Star Platinum will prevent illogical date combinations.

### Listing All Tasks

Displays all your tasks with their current status.

**Command Format:** `list`

**Example:**
```
list
```

**Expected Output:**
```
____________________________________________________________
Here are the tasks in your list:
1.[T][ ] Buy groceries
2.[D][ ] Submit assignment (by: Sep 30 2025)
3.[E][ ] Team meeting (from: Oct 01 2025 to: Oct 01 2025)
____________________________________________________________
```

### Marking Tasks as Done

Marks a task as completed using its task number.

**Command Format:** `mark TASK_NUMBER`

**Example:**
```
mark 1
```

**Expected Output:**
```
____________________________________________________________
Nice! I've marked this task as done:
  [T][X] Buy groceries
____________________________________________________________
```

### Unmarking Tasks

Marks a completed task as not done yet.

**Command Format:** `unmark TASK_NUMBER`

**Example:**
```
unmark 1
```

**Expected Output:**
```
____________________________________________________________
OK, I've marked this task as not done yet:
  [T][ ] Buy groceries
____________________________________________________________
```

### Deleting Tasks

Removes a task from your list permanently.

**Command Format:** `delete TASK_NUMBER`

**Example:**
```
delete 3
```

**Expected Output:**
```
____________________________________________________________
Noted. I've removed this task:
  [E][ ] Team meeting (from: Oct 01 2025 to: Oct 01 2025)
Now you have 2 tasks in the list.
____________________________________________________________
```

### Finding Tasks

Searches for tasks containing a specific keyword in their description (case-insensitive).

**Command Format:** `find KEYWORD`

**Example:**
```
find assignment
```

**Expected Output:**
```
____________________________________________________________
Here are the matching tasks for 'assignment':
1.[D][ ] Submit assignment (by: Sep 30 2025)
____________________________________________________________
```

### Exiting the Application

Saves all your tasks and exits Star Platinum.

**Command Format:** `bye`

**Example:**
```
bye
```

**Expected Output:**
```
____________________________________________________________
Yare Yare Daze... Star Platinum will see you again.
____________________________________________________________
```

## Command Summary

| Command | Format | Example |
|---------|--------|---------|
| Todo | `todo DESCRIPTION` | `todo Buy groceries` |
| Deadline | `deadline DESCRIPTION /by yyyy-MM-dd` | `deadline Submit assignment /by 2025-09-30` |
| Event | `event DESCRIPTION /from yyyy-MM-dd /to yyyy-MM-dd` | `event Team meeting /from 2025-10-01 /to 2025-10-01` |
| List | `list` | `list` |
| Mark | `mark TASK_NUMBER` | `mark 1` |
| Unmark | `unmark TASK_NUMBER` | `unmark 1` |
| Delete | `delete TASK_NUMBER` | `delete 1` |
| Find | `find KEYWORD` | `find assignment` |
| Exit | `bye` | `bye` |

## FAQ

**Q: How do I transfer my data to another computer?**

A: Copy the `data/tasks.txt` file to the same location on your new computer. Star Platinum will automatically load your tasks when you start the application.

**Q: What happens if I enter an invalid date format?**

A: Star Platinum will show a clear error message and guide you to use the correct `yyyy-MM-dd` format for dates.

**Q: Can I edit a task after creating it?**

A: Currently, you cannot edit existing tasks directly. You can delete the task and create a new one with the corrected information.

**Q: What if I enter a start date that is after the end date for an event?**

A: Star Platinum will prevent this and show an error message: "Invalid event dates! The start date cannot be after the end date."

**Q: Are my tasks automatically saved?**

A: Yes! Star Platinum automatically saves your tasks after every successful operation (except for listing tasks).

**Q: What if the application crashes?**

A: Don't worry! Your tasks are saved to `data/tasks.txt` after each operation, so you won't lose any data even if the application crashes.

---

For more information about Star Platinum, visit our [GitHub repository](https://github.com/Yxiang-828/ip).