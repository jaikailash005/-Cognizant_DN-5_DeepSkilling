import java.util.Scanner;

class CustomerOrder {

    int orderId;
    String customerName;
    double totalPrice;

    CustomerOrder(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    void display() {
        System.out.println(orderId + "\t\t" + customerName + "\t\t" + totalPrice);
    }
}

public class OrderSorting {

    static CustomerOrder[] orders = new CustomerOrder[100];
    static int count = 0;
    static Scanner sc = new Scanner(System.in);

    public static void addOrder() {

        System.out.print("Enter Order ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Customer Name: ");
        String name = sc.next();

        System.out.print("Enter Total Price: ");
        double price = sc.nextDouble();

        orders[count++] = new CustomerOrder(id, name, price);

        System.out.println("Order Added Successfully.");
    }

    public static void displayOrders() {

        if (count == 0) {
            System.out.println("No Orders Available.");
            return;
        }

        System.out.println("\nOrderID\t\tCustomer\t\tPrice");

        for (int i = 0; i < count; i++) {
            orders[i].display();
        }
    }

    public static void bubbleSort() {

        if (count == 0) {
            System.out.println("No Orders Available.");
            return;
        }

        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {

                if (orders[j].totalPrice > orders[j + 1].totalPrice) {

                    CustomerOrder temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }

        System.out.println("\nOrders Sorted Using Bubble Sort.");
        displayOrders();
    }

    public static int partition(int low, int high) {

        double pivot = orders[high].totalPrice;
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (orders[j].totalPrice < pivot) {

                i++;

                CustomerOrder temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        CustomerOrder temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void quickSort(int low, int high) {

        if (low < high) {

            int pi = partition(low, high);

            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    public static void quickSortOrders() {

        if (count == 0) {
            System.out.println("No Orders Available.");
            return;
        }

        quickSort(0, count - 1);

        System.out.println("\nOrders Sorted Using Quick Sort.");
        displayOrders();
    }

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== CUSTOMER ORDER SORTING SYSTEM =====");
            System.out.println("1. Add Order");
            System.out.println("2. Display Orders");
            System.out.println("3. Bubble Sort");
            System.out.println("4. Quick Sort");
            System.out.println("5. Exit");

            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addOrder();
                    break;

                case 2:
                    displayOrders();
                    break;

                case 3:
                    bubbleSort();
                    break;

                case 4:
                    quickSortOrders();
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