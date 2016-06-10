package st.pr.validator;

import st.pr.strategy.Person;

import java.util.HashSet;
import java.util.Set;

public class TestWarningValidator implements Validator <Person>{
    Set<ValidationResult> errors = new HashSet<>();

    @Override
    public void validate(final Person model) {
        errors.add(new ValidationResult("Warning", 2));
    }

    @Override
    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    @Override
    public Set<ValidationResult> getErrors() {
        return errors;
    }

    public static TestWarningValidator getInstance() {
        return new TestWarningValidator();
    }
}
