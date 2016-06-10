package st.pr.validator;

import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

public class ValidationUtils {
    public static void unless(final Optional<Set<ValidationResult>> validationResults,
                              final Predicate<Set<ValidationResult>> predicate,
                              final Function<Set<ValidationResult>, Void> callback,
                              final Runnable after) {

        validationResults.ifPresent(r -> {
            if (predicate.test(r)) callback.apply(r); else after.run();
        });
    }
}
