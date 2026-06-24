interface Notifier {

    void send(String message);
}

class EmailNotifier implements Notifier {

    public void send(String message) {
        System.out.println(
                "Email Notification: " + message);
    }
}

abstract class NotifierDecorator
        implements Notifier {

    protected Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    public void send(String message) {
        notifier.send(message);
    }
}

class SMSNotifierDecorator
        extends NotifierDecorator {

    public SMSNotifierDecorator(
            Notifier notifier) {

        super(notifier);
    }

    public void send(String message) {

        super.send(message);

        System.out.println(
                "SMS Notification: " + message);
    }
}

class SlackNotifierDecorator
        extends NotifierDecorator {

    public SlackNotifierDecorator(
            Notifier notifier) {

        super(notifier);
    }

    public void send(String message) {

        super.send(message);

        System.out.println(
                "Slack Notification: " + message);
    }
}

public class DecoratorPatternTest {

    public static void main(String[] args) {

        System.out.println(
                "----- Email Only -----");

        Notifier emailNotifier =
                new EmailNotifier();

        emailNotifier.send(
                "System Update Available");

        System.out.println();

        System.out.println(
                "----- Email + SMS -----");

        Notifier smsNotifier =
                new SMSNotifierDecorator(
                        new EmailNotifier());

        smsNotifier.send(
                "System Update Available");

        System.out.println();

        System.out.println(
                "----- Email + SMS + Slack -----");

        Notifier allNotifier =
                new SlackNotifierDecorator(
                        new SMSNotifierDecorator(
                                new EmailNotifier()));

        allNotifier.send(
                "System Update Available");
    }
}