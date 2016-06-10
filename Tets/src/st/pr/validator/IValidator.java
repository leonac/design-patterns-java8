package st.pr.validator;

import st.pr.strategy.Person;

import java.util.Set;

public interface IValidator {
    void validate(Person p);

    Set getValidationErrors();

    boolean hasErrors();
}
