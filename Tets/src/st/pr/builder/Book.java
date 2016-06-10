package st.pr.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

class Book {
    private long isbn;
    private String title;
    private int pages;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("isbn=").append(isbn);
        sb.append(", title='").append(title).append('\'');
        sb.append(", pages=").append(pages);
        sb.append('}');
        return sb.toString();
    }

    static BookBuilder builder() {
        return new BookBuilder();
    }

    static class BookBuilder {
        Book book = new Book();

        List<Consumer<Book>> modifiers = new ArrayList<>(3);

        public <U> BookBuilder with(BiConsumer<Book, U> consumer, U value) {
            Consumer<Book> c = instance -> consumer.accept(instance, value);

            modifiers.add(c);
            return this;
        }

        public Book getBook() {
            modifiers.forEach(m -> m.accept(book));

            return book;
        }
    }
}

