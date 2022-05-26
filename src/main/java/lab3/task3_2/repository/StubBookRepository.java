package lab3.task3_2.repository;

import lab3.task3_2.model.Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.concurrent.ThreadLocalRandom.current;
import static lab3.task3_2.repository.BookGeneratorUtils.getRandomAuthor;
import static lab3.task3_2.repository.BookGeneratorUtils.getRandomPublisher;

public class StubBookRepository implements BookRepository {
    private final List<Book> books;

    public StubBookRepository() {
        this.books = IntStream.range(0, 10)
                .mapToObj(e -> new Book("book" + e, getRandomAuthor(),
                        getRandomPublisher(),
                        current().nextInt(2000, 2010),
                        current().nextInt(200, 600),
                        current().nextDouble(10, 100)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        return books.stream()
                .filter(e -> e.author().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getBooksByPublisher(String publisher) {
        return books.stream()
                .filter(e -> e.publisher().equalsIgnoreCase(publisher))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getBooksPublishedAfter(int year) {
        return books.stream()
                .filter(e -> e.year() >= year)
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getSortedBooksByPublishers() {
        List<Book> result = new ArrayList<>(this.books);
        result.sort(Comparator.comparing(Book::publisher));
        return result;
    }
}
