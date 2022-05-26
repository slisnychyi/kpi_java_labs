package lab3.task3_2;

import lab3.task3_2.model.Book;
import lab3.task3_2.repository.StubBookRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Consumer;

public class App {
    private static final StubBookRepository BOOK_REPOSITORY = new StubBookRepository();
    private static final Map<String, Consumer<String>> BOOKS_BY_CRITERIA = Map.of(
            "author", e -> printBooksInfo(BOOK_REPOSITORY.getBooksByAuthor(e)),
            "publisher", e -> printBooksInfo(BOOK_REPOSITORY.getBooksByPublisher(e)),
            "year", e -> printBooksInfo(BOOK_REPOSITORY.getBooksPublishedAfter(Integer.parseInt(e)))
    );

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Books:");
        List<Book> books = BOOK_REPOSITORY.getBooks();
        printBooksInfo(books);
        System.out.println("""
                                
                Commands exists:
                - find by {author/publisher/year}:{value}
                - get sorted books
                """);

        while (true) {
            System.out.println("enter command...");
            String command = scanner.nextLine();
            if (command.contains("find by")) {
                String[] columnValue = command.replaceAll("find by", "")
                        .trim().split(":");
                Optional.ofNullable(BOOKS_BY_CRITERIA.get(columnValue[0]))
                        .ifPresentOrElse(e -> e.accept(columnValue[1]),
                                () -> System.out.println("invalid column = " + columnValue[0]));
            } else if (command.contains("get sorted books")) {
                printBooksInfo(BOOK_REPOSITORY.getSortedBooksByPublishers());
            } else {
                System.out.println("no such command");
            }
        }
    }

    private static void printBooksInfo(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("no result;");
        } else {
            books.forEach(e -> {
                System.out.printf("name=%s, author=%s, publisher=%s, year=%s\n",
                        e.name(), e.author(), e.publisher(), e.year());
            });
        }

    }
}
