import java.util.HashMap;
import java.util.Scanner;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    void display() {
        System.out.println(productId + "\t\t" +
                productName + "\t\t" +
                quantity + "\t\t" +
                price);
    }
}

public class InventoryManagement {

    static HashMap<Integer, Product> inventory = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void addProduct() {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Product Name: ");
        String name = sc.next();

        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        Product p = new Product(id, name, qty, price);
        inventory.put(id, p);

        System.out.println("Product Added Successfully.");
    }

    public static void updateProduct() {

        System.out.print("Enter Product ID to Update: ");
        int id = sc.nextInt();

        if (inventory.containsKey(id)) {

            System.out.print("Enter New Quantity: ");
            int qty = sc.nextInt();

            System.out.print("Enter New Price: ");
            double price = sc.nextDouble();

            Product p = inventory.get(id);
            p.quantity = qty;
            p.price = price;

            System.out.println("Product Updated Successfully.");
        } else {
            System.out.println("Product Not Found.");
        }
    }

    public static void deleteProduct() {

        System.out.print("Enter Product ID to Delete: ");
        int id = sc.nextInt();

        if (inventory.containsKey(id)) {
            inventory.remove(id);
            System.out.println("Product Deleted Successfully.");
        } else {
            System.out.println("Product Not Found.");
        }
    }

    public static void searchProduct() {

        System.out.print("Enter Product ID to Search: ");
        int id = sc.nextInt();

        if (inventory.containsKey(id)) {
            System.out.println("\nProduct Found:");
            inventory.get(id).display();
        } else {
            System.out.println("Product Not Found.");
        }
    }

    public static void displayInventory() {

        if (inventory.isEmpty()) {
            System.out.println("Inventory is Empty.");
            return;
        }

        System.out.println("\nID\t\tName\t\tQuantity\t\tPrice");

        for (Product p : inventory.values()) {
            p.display();
        }
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== INVENTORY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Search Product");
            System.out.println("5. Display Inventory");
            System.out.println("6. Exit");

            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addProduct();
                    break;

                case 2:
                    updateProduct();
                    break;

                case 3:
                    deleteProduct();
                    break;

                case 4:
                    searchProduct();
                    break;

                case 5:
                    displayInventory();
                    break;

                case 6:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}