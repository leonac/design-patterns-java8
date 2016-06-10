package st.pr.validator;

import st.pr.strategy.Person;

import java.util.ArrayList;
import java.util.Collection;

public class PersonValidationFactory extends ValidationExecutor {
    public static Collection<Validator<Person>> beforeSaving() {
        ArrayList<Validator<Person>> list = new ArrayList<>();
        list.add(PersonMandatoryFieldsValidator.getInstance());
        list.add(TestWarningValidator.getInstance());

        return list;
    }
}
