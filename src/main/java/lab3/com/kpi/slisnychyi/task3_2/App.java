package lab3.com.kpi.slisnychyi.task3_2;

import lab3.com.kpi.slisnychyi.task3_2.model.Book;
import lab3.com.kpi.slisnychyi.task3_2.repository.StubBookRepository;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        StubBookRepository bookRepository = new StubBookRepository();

        System.out.println("Books:");
        List<Book> books = bookRepository.getBooks();
        printBooksInfo(books);
        System.out.println("""
                                
                Commands exists:
                - find by {author/publisher/year}:{value}
                - get sorted books
                """);


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("enter command...");
            String command = scanner.nextLine();
            if (command.contains("find by")) {
                String[] columnValue = command.replaceAll("find by", "")
                        .trim().split(":");
                if (columnValue[0].equalsIgnoreCase("author")) {
                    printBooksInfo(bookRepository.getBooksByAuthor(columnValue[1]));
                } else if (columnValue[0].equalsIgnoreCase("publisher")) {
                    printBooksInfo(bookRepository.getBooksByPublisher(columnValue[1]));
                } else if (columnValue[0].equalsIgnoreCase("year")) {
                    printBooksInfo(bookRepository.getBooksPublishedAfter(Integer.parseInt(columnValue[1])));
                } else {
                    System.out.println("invalid column = " + columnValue[0]);
                }
            } else if (command.contains("get sorted books")) {
                printBooksInfo(bookRepository.getSortedBooksByPublishers());
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
