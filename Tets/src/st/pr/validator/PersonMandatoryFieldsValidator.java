package st.pr.validator;

import st.pr.strategy.Person;

import java.util.HashSet;
import java.util.Set;

public class PersonMandatoryFieldsValidator implements Validator<Person> {
    Set<ValidationResult> errors = new HashSet<>();

    public static PersonMandatoryFieldsValidator getInstance() {
        return new PersonMandatoryFieldsValidator();
    }

    @Override
    public void validate(final Person person) {
        if (person.getFirstName() == null || "".equals(person.getFirstName()))
            errors.add(new ValidationResult("First name should not be empty", 0));

        if (person.getAge() == 0) {
            errors.add(new ValidationResult("Age should be not 0", 1));
        }

    }

    @Override
    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    @Override
    public Set<ValidationResult> getErrors() {
        return errors;
    }
}
