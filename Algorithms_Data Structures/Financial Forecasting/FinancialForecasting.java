import java.util.Scanner;

public class FinancialForecasting {

    static Scanner sc = new Scanner(System.in);

    public static double predictFutureValue(double currentValue,
                                            double growthRate,
                                            int years) {

        if (years == 0) {
            return currentValue;
        }

        return predictFutureValue(
                currentValue * (1 + growthRate / 100),
                growthRate,
                years - 1);
    }

    public static void forecast() {

        System.out.print("Enter Current Value: ");
        double currentValue = sc.nextDouble();

        System.out.print("Enter Growth Rate (%): ");
        double growthRate = sc.nextDouble();

        System.out.print("Enter Number of Years: ");
        int years = sc.nextInt();

        double futureValue =
                predictFutureValue(currentValue,
                                   growthRate,
                                   years);

        System.out.printf("Predicted Future Value: %.2f%n",
                          futureValue);
    }

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== FINANCIAL FORECASTING SYSTEM =====");
            System.out.println("1. Predict Future Value");
            System.out.println("2. Exit");

            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    forecast();
                    break;

                case 2:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 2);

        sc.close();
    }
}