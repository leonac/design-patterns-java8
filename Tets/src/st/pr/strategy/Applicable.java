package st.pr.strategy;

import java.util.function.Function;

public interface Applicable<T> {
    default boolean isApplicableFor(T model) {
        return false;
    }

    default  <R> R ifApplicableFor(T model, Function<T, R> callback) {
        return isApplicableFor(model)? callback.apply(model): null;
    }

}
