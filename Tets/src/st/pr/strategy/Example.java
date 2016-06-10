package st.pr.strategy;

import java.util.Optional;
import java.util.stream.Stream;

public class Example {

    public static void main(String[] args) {
        Person person = new Person();
        person.setFirstName("Bill");
        person.setLastName("Gates");
        person.setAge(0);

        ValidationStrategy<Person> nameValidator =
                p -> (p.getFirstName().isEmpty()) ?
                        Optional.of("first name is mandatory field") :
                        Optional.<String>empty();

        ValidationStrategy<Person> ageValidator =
                p -> (p.getAge() > 120 || p.getAge() <= 0) ?
                        Optional.of("value of 'age' is incorrect") :
                        Optional.<String>empty();

        Stream.of(nameValidator, ageValidator).forEach(v -> {
            v.ifApplicableFor(person,
                    (Person p) -> {
                        v.validate(p).ifPresent(System.out::println);
                        return null;
                    });
        });



    }
}



























