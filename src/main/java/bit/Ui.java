package bit;

/**
 * This class deals with returning strings to user
 */
public class Ui {
    public String greet() {
        return "Hi! This is Bit!\nWhat shall we do today?");
    }

    public String sayBye() {
        return "Alright. See you soon!!";
    }

    public String fileError() {
        return "Error! Something went wrong while creating your file!";
    }

    /**
     * Print out all tasks in task list.
     * @param tasklist list to be printed out.
     */
    public String listOut(Tasklist tasklist) {
        System.out.println("Sure! Here is the list:\n");
        for (int i = 0; i < tasklist.getSize(); i++) {
            if (tasklist.getTask(i) == null) {
                break;
            }
            System.out.println((i + 1) + "." + tasklist.getTask(i).toString());
        }
    }

    /**
     * Used to acknowledge that mark command was successful.
     * @param task task that was marked.
     */
    public void  sayMarked(Task task) {
        System.out.println("Done and dusted: " + task.toString());
    }

    /**
     * Used to acknowledge that unmark command was successful.
     * @param task task that was unmarked
     */
    public void sayUnmarked(Task task) {
        System.out.println("Alright, let me uncheck that for you: " + task.toString());
    }

    /**
     * Acknowledge to user that task was successfully added
     * @param i index of added task
     * @param string type of task
     * @param task the task itself
     */
    public void sayAdded(int i, String string, Task task) {
        switch (string) {
        case "todo":
            System.out.println("I have added this todo: " + i + '.' + task.toString());
            break;
        case "event":
            System.out.println("I have added this event: " + (i) + " " + task.toString());
            break;
        case "deadline":
            System.out.println("Done! I have added this deadline" + task.toString());
        default:
            break;
        }
    }

    /**
     * Acknowledge that task was deleted
     * @param s Deleted task in string format.
     */
    public void sayDeleted(String s) {
        System.out.println("Got it! I have deleted this item: " + s);
    }

    /**
     * Print out error messages for error handling.
     * @param string Type of error to be handled.
     */
    public void handleErrorMessage(String string) {
        switch (string) {
        case "absent":
            System.out.println("Hey, I don't think you have added that yet!");
            break;
        case "Not a number":
            System.out.println("Woah! That is not a number!");
            break;
        case "forget":
            System.out.println("Did you forget something?");
            break;
        case "NotaDate":
            System.out.println("The date you entered is invalid.");
            break;
        default:
            System.out.println("Sorry, I don't understand what you mean\n");
            break;
        }
    }


    public void printException(Exception e) {
        System.out.println(e.getMessage());
    }

    /**
     * List all items in tasklist containing the keyword.
     * @param key the keyword for the search.
     * @param tasklist the tasklist being searched.
     */
    public void listHits(String key, Tasklist tasklist) {
        System.out.println("Sure! Here are the matches:\n");
        int j = 1;
        for (int i = 0; i < tasklist.getSize(); i++) {
            if (tasklist.getTask(i) == null) {
                break;
            }
            Task task = tasklist.getTask(i);
            if (task.containsKeyword(key)) {
                System.out.println((j) + "." + tasklist.getTask(i).toString());
                j++;
            }

        }
    }
}
