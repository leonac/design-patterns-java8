package st.pr.observer;

public class Andrey implements StockPriceIncreaseObserver {
    @Override
    public void handleEvent() {
        System.out.println("sell everything");
    }
}
