import java.util.ArrayList;
import java.util.List;

interface Observer {

    void update(String stockName,
                double stockPrice);
}

interface Stock {

    void registerObserver(
            Observer observer);

    void deregisterObserver(
            Observer observer);

    void notifyObservers();
}

class StockMarket implements Stock {

    private List<Observer> observers =
            new ArrayList<>();

    private String stockName;
    private double stockPrice;

    public void setStockData(
            String stockName,
            double stockPrice) {

        this.stockName = stockName;
        this.stockPrice = stockPrice;

        notifyObservers();
    }

    public void registerObserver(
            Observer observer) {

        observers.add(observer);
    }

    public void deregisterObserver(
            Observer observer) {

        observers.remove(observer);
    }

    public void notifyObservers() {

        for (Observer observer :
                observers) {

            observer.update(
                    stockName,
                    stockPrice);
        }
    }
}

class MobileApp implements Observer {

    private String userName;

    public MobileApp(
            String userName) {

        this.userName = userName;
    }

    public void update(
            String stockName,
            double stockPrice) {

        System.out.println(
                "Mobile App [" +
                userName +
                "] - Stock: " +
                stockName +
                " Price: " +
                stockPrice);
    }
}

class WebApp implements Observer {

    private String userName;

    public WebApp(
            String userName) {

        this.userName = userName;
    }

    public void update(
            String stockName,
            double stockPrice) {

        System.out.println(
                "Web App [" +
                userName +
                "] - Stock: " +
                stockName +
                " Price: " +
                stockPrice);
    }
}

public class ObserverPatternTest {

    public static void main(String[] args) {

        StockMarket stockMarket =
                new StockMarket();

        Observer mobileUser =
                new MobileApp("John");

        Observer webUser =
                new WebApp("David");

        stockMarket.registerObserver(
                mobileUser);

        stockMarket.registerObserver(
                webUser);

        System.out.println(
                "Stock Price Updated");

        stockMarket.setStockData(
                "TCS",
                4200.50);

        System.out.println();

        System.out.println(
                "Removing Web Observer");

        stockMarket.deregisterObserver(
                webUser);

        System.out.println();

        stockMarket.setStockData(
                "Infosys",
                1650.75);
    }
}