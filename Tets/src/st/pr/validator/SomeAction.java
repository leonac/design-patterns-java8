package st.pr.validator;

import st.pr.strategy.Person;

import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

import static st.pr.validator.PersonValidationFactory.beforeSaving;
import static st.pr.validator.ValidationExecutor.validate;
import static st.pr.validator.ValidationUtils.unless;

public class SomeAction {

    public static void main(String[] args) {
        Person person = new Person();

        person.setFirstName("Andrey");
        person.setLastName("Parkhomenko");
        person.setAge(0);

        Optional<Set<ValidationResult>> validationResults = validate(person, beforeSaving());
        validationResults.ifPresent(v -> v.stream().map(r -> r.message).forEach(System.out::println));

        Predicate<Set<ValidationResult>> hasErrors = (Set<ValidationResult> results) ->
                results.stream().filter(r -> r.errorCode == 1).findAny().isPresent();
        Predicate<Set<ValidationResult>> hasWarnings = (Set<ValidationResult> results) ->
                results.stream().filter(r -> r.errorCode == 2).findAny().isPresent();

        Function<Set<ValidationResult>, Set<ValidationResult>> showErrors = (Set<ValidationResult> results) ->
        { results.stream().filter(r -> r.errorCode == 1).forEach(System.out::println); return results;};
        Function<Set<ValidationResult>, Void> showWarnings = (Set<ValidationResult> results) ->
        { results.stream().filter(r -> r.errorCode == 2).forEach(System.out::println); return null;};


        unless(validationResults, hasErrors.or(hasWarnings), showErrors.andThen(showWarnings),
                () -> System.out.println("Ok"));
    }
}


