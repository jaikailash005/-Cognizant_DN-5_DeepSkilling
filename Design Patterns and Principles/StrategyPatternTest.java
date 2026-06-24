interface PaymentStrategy {

    void pay(double amount);
}

class CreditCardPayment
        implements PaymentStrategy {

    public void pay(double amount) {

        System.out.println(
                "Paid Rs." + amount +
                " using Credit Card");
    }
}

class PayPalPayment
        implements PaymentStrategy {

    public void pay(double amount) {

        System.out.println(
                "Paid Rs." + amount +
                " using PayPal");
    }
}

class PaymentContext {

    private PaymentStrategy strategy;

    public void setPaymentStrategy(
            PaymentStrategy strategy) {

        this.strategy = strategy;
    }

    public void executePayment(
            double amount) {

        strategy.pay(amount);
    }
}

public class StrategyPatternTest {

    public static void main(String[] args) {

        PaymentContext context =
                new PaymentContext();

        System.out.println(
                "Using Credit Card Strategy");

        context.setPaymentStrategy(
                new CreditCardPayment());

        context.executePayment(5000);

        System.out.println();

        System.out.println(
                "Using PayPal Strategy");

        context.setPaymentStrategy(
                new PayPalPayment());

        context.executePayment(7500);
    }
}