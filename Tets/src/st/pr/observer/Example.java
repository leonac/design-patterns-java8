package st.pr.observer;

public class Example {
    public static void main(String[] args) {
        StockExchange stockExchange = new StockExchange();

        stockExchange.listenStockPriceDecrease(() -> System.out.println("buy"));
        stockExchange.listenStockPriceIncrease(() -> System.out.println("sell"));

        stockExchange.exchange();
    }
}
