package lab8.task8_2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class App {
    private static final ForkJoinPool FORK_JOIN_POOL = new ForkJoinPool();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] values = generateElems(10);
        System.out.println("Values = " + Arrays.toString(values));
        int sum = calculateSum(values, 0, values.length - 1);
        System.out.println("Sum = " + sum);
    }

    private static int calculateSum(int[] values, int i, int j) throws ExecutionException, InterruptedException {
        if (j - i <= 2) {
            int sum = 0;
            while (i < j) {
                sum += values[i++];
            }
            return sum;
        }
        int mid = ((j - i) / 2) + i;
        int finalI = i;
        return calculateSum(values, finalI, mid) + calculateSum(values, mid, j);
    }

    private static int[] generateElems(int size) {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = ThreadLocalRandom.current().nextInt(101);
        }
        return result;
    }

}
