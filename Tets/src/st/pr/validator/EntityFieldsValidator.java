package st.pr.validator;

import java.util.HashSet;
import java.util.Set;

public class EntityFieldsValidator implements Validator<Entity> {
    private Set<String> errors = new HashSet<>();

    @Override
    public void validate(final Entity model) {
        if (model.getTitle() == null || "".equals(model.getTitle()))
            errors.add("Title should not be empty");

        if (model.getCount() < 0)
            errors.add("Count should be greater then 0");
    }

    @Override
    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    @Override
    public Set<String> getErrors() {
        return errors;
    }
}
