import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Book {

    int bookId;
    String title;
    String author;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    void display() {
        System.out.println(bookId + "\t\t" +
                title + "\t\t" +
                author);
    }
}

public class LibraryManagement {

    static Book[] books = new Book[100];
    static int count = 0;
    static Scanner sc = new Scanner(System.in);

    public static void addBook() {

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Book Title: ");
        String title = sc.next();

        System.out.print("Enter Author Name: ");
        String author = sc.next();

        books[count++] = new Book(id, title, author);

        System.out.println("Book Added Successfully.");
    }

    public static void displayBooks() {

        if (count == 0) {
            System.out.println("No Books Available.");
            return;
        }

        System.out.println("\nBookID\t\tTitle\t\tAuthor");

        for (int i = 0; i < count; i++) {
            books[i].display();
        }
    }

    public static void linearSearch() {

        System.out.print("Enter Book Title: ");
        String target = sc.next();

        boolean found = false;

        for (int i = 0; i < count; i++) {

            if (books[i].title.equalsIgnoreCase(target)) {

                System.out.println("\nBook Found (Linear Search)");
                books[i].display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book Not Found.");
        }
    }

    public static void binarySearch() {

        if (count == 0) {
            System.out.println("No Books Available.");
            return;
        }

        Book[] sortedBooks = Arrays.copyOf(books, count);

        Arrays.sort(sortedBooks,
                Comparator.comparing(
                        b -> b.title.toLowerCase()));

        System.out.print("Enter Book Title: ");
        String target = sc.next();

        int low = 0;
        int high = count - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int result =
                    sortedBooks[mid].title
                            .compareToIgnoreCase(target);

            if (result == 0) {

                System.out.println(
                        "\nBook Found (Binary Search)");

                sortedBooks[mid].display();
                return;

            } else if (result < 0) {

                low = mid + 1;

            } else {

                high = mid - 1;
            }
        }

        System.out.println("Book Not Found.");
    }

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Linear Search");
            System.out.println("4. Binary Search");
            System.out.println("5. Exit");

            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    displayBooks();
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