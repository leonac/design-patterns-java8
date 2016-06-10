package st.pr.strategy;

import java.util.Optional;
import java.util.function.Function;

public interface ValidationStrategy<T> {
    Optional<String> validate(T model);

    default boolean isApplicableFor(T model) {
        return false;
    }

    default void ifApplicableFor(T model, Function<T, Void> callback) {
        if (isApplicableFor(model)) callback.apply(model);
    }
}
