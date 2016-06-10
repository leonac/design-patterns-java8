package st.pr.builder;

import java.util.function.*;

import static st.pr.builder.ObjectBuilder.of;

public class Example {
    public static void main(String[] args) {

        Supplier<Book> s = Book::new;

        BiConsumer<Book, Long> setIsbn = Book::setIsbn;


        Book book = Book.builder()
                .with(Book::setTitle, "test")
                .with(Book::setPages, 300)
                .with(Book::setIsbn, 232323L)
                .getBook();

        Book b = of(Book::new)
                .with(Book::setPages, 400)
                .with(Book::setIsbn, 232323L)
                .with(Book::setTitle, "test")
                .build();


        System.out.println(b);
    }
}
