package lab3.task3_2.repository;

import lab3.task3_2.model.Book;

import java.util.List;

public interface BookRepository {
    List<Book> getBooks();

    List<Book> getBooksByAuthor(String author);

    List<Book> getBooksByPublisher(String publisher);

    List<Book> getBooksPublishedAfter(int year);

    List<Book> getSortedBooksByPublishers();

}
