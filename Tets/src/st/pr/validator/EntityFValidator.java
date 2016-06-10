package st.pr.validator;

import org.hamcrest.Matcher;

import java.util.HashSet;
import java.util.Set;

public class EntityFValidator implements Validator<Entity>{
    private Set<ValidationResult> errors = new HashSet<>();

    public void validate(final Entity e) {
        if (e.getTitle().isEmpty() || "".equals(e.getTitle()))
            errors.add(new ValidationResult("Title should not be empty", 0x1));
        else if (e.getTitle().length() > 10)
            errors.add(new ValidationResult("Title should be less then 10 symbols", 0x2));
    }

    public Set<ValidationResult> getErrors() {
        return errors;
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }
}
