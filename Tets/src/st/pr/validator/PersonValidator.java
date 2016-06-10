package st.pr.validator;

import st.pr.strategy.Person;

import java.util.HashSet;
import java.util.Set;

public class PersonValidator implements IValidator {
    Set<String> validationErrors = new HashSet<>();

    @Override
    public void validate(final Person p) {
        if (p.getFirstName().isEmpty() || "".equals(p.getFirstName())) {
            validationErrors.add("FirstName is empty");
        }
        else if (p.getFirstName().length() > 10)
            validationErrors.add("FirstName contains more then 10 symbols");
    }

    @Override
    public Set getValidationErrors() {
        return validationErrors;
    }

    @Override
    public boolean hasErrors() {
        return !validationErrors.isEmpty();
    }
}
