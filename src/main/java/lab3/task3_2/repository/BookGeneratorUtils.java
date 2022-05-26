package lab3.task3_2.repository;

import java.util.concurrent.ThreadLocalRandom;

public class BookGeneratorUtils {
    private static final String[] AUTHORS = {"author1", "author2", "author3"};
    private static final String[] PUBLISHERS = {"publisher1", "publisher2", "publisher3"};

    public static String getRandomAuthor() {
        return AUTHORS[ThreadLocalRandom.current().nextInt(3)];
    }

    public static String getRandomPublisher() {
        return PUBLISHERS[ThreadLocalRandom.current().nextInt(3)];
    }
}
