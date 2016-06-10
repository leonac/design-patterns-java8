package st.pr.validator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class EntityFieldsValidatorTest {
    EntityFValidator validator;

    @Before
    public void init() {
        validator = new EntityFValidator();

    }

    @Test
    /**
     * Providing an empty string to the validator, it should signal that entity is not valid
     */
    public void test_Incorrect_Title_field_validationError() {
        Entity e = new Entity();
        e.setTitle("");
        validator.validate(e);

        assertTrue("validator contains errors", validator.hasErrors());
        assertTrue("Validator should contain the validation error", validator.getErrors().stream().anyMatch(err -> err.errorCode == 0x1));
    }

    @Test
    public void test_Incorrect_Title_field_tooBig_validationError() {
        Entity e = new Entity();
        e.setTitle("EEEEÂËEEEEDDSA");

        validator.validate(e);

        assertTrue("Validator should contain the validation error", validator.getErrors().stream().anyMatch(err -> err.errorCode == 0x2));
    }

    @Test
    public void test_correct_title_no_errors() {
        Entity e = new Entity();
        e.setTitle("ABC");

        validator.validate(e);

        assertFalse(validator.hasErrors());
    }
}