import java.util.Scanner;

interface Document {
    void open();
}

class WordDocument implements Document {

    public void open() {
        System.out.println("Opening Word Document");
    }
}

class PdfDocument implements Document {

    public void open() {
        System.out.println("Opening PDF Document");
    }
}

class ExcelDocument implements Document {

    public void open() {
        System.out.println("Opening Excel Document");
    }
}

abstract class DocumentFactory {

    public abstract Document createDocument();
}

class WordDocumentFactory extends DocumentFactory {

    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfDocumentFactory extends DocumentFactory {

    public Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelDocumentFactory extends DocumentFactory {

    public Document createDocument() {
        return new ExcelDocument();
    }
}

public class FactoryMethodTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n===== FACTORY METHOD PATTERN =====");
            System.out.println("1. Word Document");
            System.out.println("2. PDF Document");
            System.out.println("3. Excel Document");
            System.out.println("4. Exit");

            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();

            DocumentFactory factory = null;

            switch (choice) {

                case 1:
                    factory = new WordDocumentFactory();
                    break;

                case 2:
                    factory = new PdfDocumentFactory();
                    break;

                case 3:
                    factory = new ExcelDocumentFactory();
                    break;

                case 4:
                    System.out.println("Exiting Program...");
                    continue;

                default:
                    System.out.println("Invalid Choice.");
                    continue;
            }

            Document document = factory.createDocument();
            document.open();

        } while (choice != 4);

        sc.close();
    }
}