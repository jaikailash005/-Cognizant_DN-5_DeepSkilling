interface PaymentProcessor {

    void processPayment(double amount);
}

class PayPalGateway {

    public void makePayment(double amount) {
        System.out.println(
                "Payment of Rs." + amount +
                " processed through PayPal.");
    }
}

class StripeGateway {

    public void payAmount(double amount) {
        System.out.println(
                "Payment of Rs." + amount +
                " processed through Stripe.");
    }
}

class PayPalAdapter implements PaymentProcessor {

    private PayPalGateway payPalGateway;

    public PayPalAdapter(PayPalGateway payPalGateway) {
        this.payPalGateway = payPalGateway;
    }

    public void processPayment(double amount) {
        payPalGateway.makePayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {

    private StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    public void processPayment(double amount) {
        stripeGateway.payAmount(amount);
    }
}

public class AdapterPatternTest {

    public static void main(String[] args) {

        PaymentProcessor payPal =
                new PayPalAdapter(
                        new PayPalGateway());

        PaymentProcessor stripe =
                new StripeAdapter(
                        new StripeGateway());

        payPal.processPayment(5000);

        stripe.processPayment(7500);
    }
}