package st.pr.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ObjectBuilder<T> {

    private final Supplier<T> supplier;
    private List<Consumer<T>> consumers = new ArrayList<>();

    public ObjectBuilder(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    public static <T> ObjectBuilder<T> of(Supplier<T> supplier) {
        return new ObjectBuilder<T>(supplier);
    }

    public <U> ObjectBuilder<T> with(BiConsumer<T, U> consumer, U value) {
        Consumer<T> c = instance -> consumer.accept(instance, value);

        consumers.add(c);

        return this;
    }

    public T build() {
        T value = supplier.get();
        consumers.forEach( c -> c.accept(value));
        consumers.clear();

        return value;
    }
}
