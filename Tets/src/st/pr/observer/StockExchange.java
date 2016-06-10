package st.pr.observer;

import java.util.Random;
import java.util.concurrent.locks.LockSupport;

public class StockExchange {
    private Observable stockPriceIncreasePublisher = new StockPriceIncreasePublisher();
    private Observable stockPriceDecreasePublisher = new StockPriceDecreasePublisher();

    public void exchange() {
        while (true) {
            int e = new Random().nextInt();
            if (e >= 0) stockPriceIncreasePublisher.notifyObservers();
            else stockPriceDecreasePublisher.notifyObservers();

            LockSupport.parkNanos(1000 * 1000 * 100 * 2);
        }
    }

    public void listenStockPriceIncrease(Observer observer) {
        stockPriceIncreasePublisher.registerObserver(observer);
    }

    public void listenStockPriceDecrease(Observer observer) {
        stockPriceDecreasePublisher.registerObserver(observer);
    }
}
