package st.pr.observer;

import java.util.HashSet;
import java.util.Set;

public class StockExchangePublisher implements Observable {
    Set<Observer> observers = new HashSet<>();

    @Override
    public void registerObserver(final Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(final Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.stream().forEach(Observer::handleEvent);
    }
}
