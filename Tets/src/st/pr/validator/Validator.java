package st.pr.validator;

import java.util.Set;

public interface Validator<T> {
    void validate(T model);

    boolean hasErrors();

    <E> Set<E> getErrors();

    default boolean isApplicableFor(T value) {
        return true;
    }
}
