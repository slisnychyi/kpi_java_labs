package lab8.task8_2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class App {
    private static final ForkJoinPool FORK_JOIN_POOL = new ForkJoinPool();

    public static void main(String[] args) {
        int[] values = generateElems(5);
        System.out.println("Values = " + Arrays.toString(values));
        int sum = calculateSum(values, 0, values.length - 1);
        System.out.println("Sum = " + sum);
    }

    private static int calculateSum(int[] values, int i, int j) {
        if (j - i <= 2) {
            int sum = 0;
            while (i < j) {
                sum += values[i++];
            }
            return sum;
        }
        int mid = ((j - i) / 2) + i;
        int finalI = i;
        return FORK_JOIN_POOL.invokeAll(List.of(
                () -> calculateSum(values, finalI, mid),
                (Callable<Integer>) () -> calculateSum(values, mid, j)
        )).stream()
                .mapToInt(App::execute)
                .sum();
    }

    private static Integer execute(Future<Integer> e) {
        try {
            return e.get();
        } catch (InterruptedException | ExecutionException interruptedException) {
            interruptedException.printStackTrace();
            throw new IllegalStateException();
        }
    }


    private static int[] generateElems(int size) {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = ThreadLocalRandom.current().nextInt(101);
        }
        return result;
    }

}
