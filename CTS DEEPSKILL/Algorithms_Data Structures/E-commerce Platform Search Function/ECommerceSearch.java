import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class SearchProduct {

    int productId;
    String productName;
    String category;

    SearchProduct(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    void display() {
        System.out.println(productId + "\t\t" +
                productName + "\t\t" +
                category);
    }
}

public class ECommerceSearch {

    static SearchProduct[] products = new SearchProduct[100];
    static int count = 0;
    static Scanner sc = new Scanner(System.in);

    public static void addProduct() {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Product Name: ");
        String name = sc.next();

        System.out.print("Enter Category: ");
        String category = sc.next();

        products[count++] = new SearchProduct(id, name, category);

        System.out.println("Product Added Successfully.");
    }

    public static void displayProducts() {

        if (count == 0) {
            System.out.println("No Products Available.");
            return;
        }

        System.out.println("\nID\t\tName\t\tCategory");

        for (int i = 0; i < count; i++) {
            products[i].display();
        }
    }

    public static void linearSearch() {

        System.out.print("Enter Product Name to Search: ");
        String target = sc.next();

        boolean found = false;

        for (int i = 0; i < count; i++) {

            if (products[i].productName.equalsIgnoreCase(target)) {

                System.out.println("\nProduct Found (Linear Search)");
                products[i].display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Product Not Found.");
        }
    }

    public static void binarySearch() {

        if (count == 0) {
            System.out.println("No Products Available.");
            return;
        }

        SearchProduct[] sortedProducts =
                Arrays.copyOf(products, count);

        Arrays.sort(sortedProducts,
                Comparator.comparing(
                        p -> p.productName.toLowerCase()));

        System.out.print("Enter Product Name to Search: ");
        String target = sc.next();

        int low = 0;
        int high = count - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int result =
                    sortedProducts[mid].productName
                            .compareToIgnoreCase(target);

            if (result == 0) {

                System.out.println(
                        "\nProduct Found (Binary Search)");

                sortedProducts[mid].display();
                return;

            } else if (result < 0) {

                low = mid + 1;

            } else {

                high = mid - 1;
            }
        }

        System.out.println("Product Not Found.");
    }

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println(
                    "\n===== E-COMMERCE SEARCH SYSTEM =====");

            System.out.println("1. Add Product");
            System.out.println("2. Display Products");
            System.out.println("3. Linear Search");
            System.out.println("4. Binary Search");
            System.out.println("5. Exit");

            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addProduct();
                    break;

                case 2:
                    displayProducts();
                    break;

                case 3:
                    linearSearch();
                    break;

                case 4:
                    binarySearch();
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