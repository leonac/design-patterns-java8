package st.pr.validator;

import java.util.*;

public abstract class ValidationExecutor {

    static <T> Optional<Set<ValidationResult>> validate(T entity, Validator<T> ... validators) {
        return validate(entity, Arrays.asList(validators));
    }

    static <T> Optional<Set<ValidationResult>> validate(T entity, Collection<Validator<T>> validators) {
        Set<ValidationResult> errors = new HashSet<>();

        validators.stream().forEach(v -> {
            if (v.isApplicableFor(entity)) v.validate(entity);
            if (v.hasErrors()) errors.addAll(v.getErrors());
        });

        return Optional.of(errors);
    }
}
