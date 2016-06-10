package st.pr.validator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import st.pr.strategy.Person;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class PersonFieldsValidatorTest {
    IValidator personValidator;
    Person person;

    @Before
    public void init() {
        personValidator = new PersonValidator();
        person = new Person();
    }

    @Test
    public void test_Person_firstNameIsEmpty_validationError() {

        person.setFirstName("");

        personValidator.validate(person);

        assert personValidator.getValidationErrors()
                .contains("FirstName is empty");
    }

    @Test
    public void Person_firstName_moreThen10_validationError() {

        person.setFirstName("12345678910");

        personValidator.validate(person);

        assert personValidator.getValidationErrors()
                .contains("FirstName contains more then 10 symbols");
    }

    @Test
    public void test_correctFirstName_success() {
        person.setFirstName("Andrey");

        personValidator.validate(person);

        assertFalse("Have no validation errors", personValidator.hasErrors());
    }
}
