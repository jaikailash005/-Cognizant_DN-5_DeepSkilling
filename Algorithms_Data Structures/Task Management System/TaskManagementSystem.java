import java.util.Scanner;

class Task {

    int taskId;
    String taskName;
    String status;
    Task next;

    Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }
}

public class TaskManagementSystem {

    static Task head = null;
    static Scanner sc = new Scanner(System.in);

    public static void addTask() {

        System.out.print("Enter Task ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Task Name: ");
        String name = sc.next();

        System.out.print("Enter Status: ");
        String status = sc.next();

        Task newTask = new Task(id, name, status);

        if (head == null) {
            head = newTask;
        } else {
            Task temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newTask;
        }

        System.out.println("Task Added Successfully.");
    }

    public static void searchTask() {

        if (head == null) {
            System.out.println("No Tasks Available.");
            return;
        }

        System.out.print("Enter Task ID to Search: ");
        int id = sc.nextInt();

        Task temp = head;

        while (temp != null) {

            if (temp.taskId == id) {
                System.out.println("\nTask Found:");
                System.out.println("ID\tTask Name\tStatus");
                System.out.println(temp.taskId + "\t" + temp.taskName + "\t\t" + temp.status);
                return;
            }

            temp = temp.next;
        }

        System.out.println("Task Not Found.");
    }

    public static void displayTasks() {

        if (head == null) {
            System.out.println("No Tasks Available.");
            return;
        }

        System.out.println("\nID\tTask Name\tStatus");

        Task temp = head;

        while (temp != null) {
            System.out.println(temp.taskId + "\t" + temp.taskName + "\t\t" + temp.status);
            temp = temp.next;
        }
    }

    public static void deleteTask() {

        if (head == null) {
            System.out.println("No Tasks Available.");
            return;
        }

        System.out.print("Enter Task ID to Delete: ");
        int id = sc.nextInt();

        if (head.taskId == id) {
            head = head.next;
            System.out.println("Task Deleted Successfully.");
            return;
        }

        Task temp = head;

        while (temp.next != null && temp.next.taskId != id) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Task Not Found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Task Deleted Successfully.");
        }
    }

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== TASK MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");

            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addTask();
                    break;

                case 2:
                    searchTask();
                    break;

                case 3:
                    displayTasks();
                    break;

                case 4:
                    deleteTask();
                    break;

                case 5:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}