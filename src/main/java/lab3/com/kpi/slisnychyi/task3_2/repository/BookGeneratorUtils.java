package lab3.com.kpi.slisnychyi.task3_2.repository;

import java.util.concurrent.ThreadLocalRandom;

public class BookGeneratorUtils {
    private static String[] authors = {"author1", "author2", "author3"};
    private static String[] publishers = {"publisher1", "publisher2", "publisher3"};

    public static String getRandomAuthor() {
        return authors[ThreadLocalRandom.current().nextInt(3)];
    }

    public static String getRandomPublisher() {
        return publishers[ThreadLocalRandom.current().nextInt(3)];
    }
}
