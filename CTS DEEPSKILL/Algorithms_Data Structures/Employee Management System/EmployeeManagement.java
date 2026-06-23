import java.util.Scanner;

class Employee {

    int employeeId;
    String name;
    String position;
    double salary;

    Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    void display() {
        System.out.println(employeeId + "\t\t" +
                name + "\t\t" +
                position + "\t\t" +
                salary);
    }
}

public class EmployeeManagement {

    static Employee[] employees = new Employee[100];
    static int count = 0;
    static Scanner sc = new Scanner(System.in);

    public static void addEmployee() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Employee Name: ");
        String name = sc.next();

        System.out.print("Enter Position: ");
        String position = sc.next();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        employees[count++] = new Employee(id, name, position, salary);

        System.out.println("Employee Added Successfully.");
    }

    public static void searchEmployee() {

        System.out.print("Enter Employee ID to Search: ");
        int id = sc.nextInt();

        for (int i = 0; i < count; i++) {

            if (employees[i].employeeId == id) {

                System.out.println("\nEmployee Found:");
                System.out.println("ID\t\tName\t\tPosition\t\tSalary");
                employees[i].display();
                return;
            }
        }

        System.out.println("Employee Not Found.");
    }

    public static void displayEmployees() {

        if (count == 0) {
            System.out.println("No Employees Available.");
            return;
        }

        System.out.println("\nID\t\tName\t\tPosition\t\tSalary");

        for (int i = 0; i < count; i++) {
            employees[i].display();
        }
    }

    public static void deleteEmployee() {

        System.out.print("Enter Employee ID to Delete: ");
        int id = sc.nextInt();

        int index = -1;

        for (int i = 0; i < count; i++) {

            if (employees[i].employeeId == id) {
                index = i;
                break;
            }
        }

        if (index == -1) {

            System.out.println("Employee Not Found.");
            return;
        }

        for (int i = index; i < count - 1; i++) {
            employees[i] = employees[i + 1];
        }

        employees[count - 1] = null;
        count--;

        System.out.println("Employee Deleted Successfully.");
    }

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Display Employees");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");

            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addEmployee();
                    break;

                case 2:
                    searchEmployee();
                    break;

                case 3:
                    displayEmployees();
                    break;

                case 4:
                    deleteEmployee();
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