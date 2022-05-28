package lab8.task8_3;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import static java.nio.file.StandardOpenOption.APPEND;

public class App {
    public static void main(String[] args) {
        File dir = Paths.get("/Users/sergiilisnychyi/Documents/").toFile();
        Path resultPath = Paths.get("src/main/resources/word_counter.txt");
        String word = "a";
        processDir(dir, resultPath, word);
    }

    private static void processDir(File dir, Path resultPath, String word) {
        Optional.ofNullable(dir)
                .filter(File::exists)
                .filter(File::isDirectory)
                .map(File::listFiles)
                .ifPresent(files -> {
                    for (File file : files) {
                        if (file.isDirectory()) {
                            CompletableFuture.runAsync(() -> processDir(file, resultPath, word)).join();
                        } else {
                            String fileName = file.getName();
                            if (isExtension(fileName, "txt")) {
                                processFile(file, resultPath, word);
                            }
                        }
                    }
                });
    }

    private synchronized static void processFile(File file, Path resultPath, String word) {
        try {
            System.out.println("reading file = " + file);
            long words = Files.readAllLines(file.toPath(), Charset.forName("ISO-8859-1")).stream()
                    .flatMap(e -> Arrays.stream(e.split(" ")))
                    .filter(e -> e.startsWith(word))
                    .count();
            String line = file.getAbsolutePath() + " = " + words + "\n";
            Files.write(resultPath, line.getBytes(), APPEND);
        } catch (IOException e) {
            System.out.println("unable to read file, cause = " + e.getMessage());
        }
    }

    private static boolean isExtension(String fileName, String extension) {
        return fileName.substring(fileName.lastIndexOf(".") + 1).equals(extension);
    }

}
