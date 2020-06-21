package concurrent;

import java.util.Arrays;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/4 13:12
 */
public class Summing2 {
    static long basicSum(long[] ia) {
        long sum = 0;
        int size = ia.length;
        for (int i = 0; i < size; i++) {
            sum += ia[i];
        }
        return sum;
    }

    public static final int SZ = 100000000;
    public static final long CHECK = (long) SZ * ((long) SZ + 1) / 2;

    public static void main(String[] args) {
        System.out.println(CHECK);
        long[] la = new long[SZ + 1];
        Arrays.parallelSetAll(la, i -> i);
        Summing.timeTest("Array stream sum", CHECK, () -> Arrays.stream(la).sum());
        Summing.timeTest("Parallel", CHECK, () -> Arrays.stream(la).parallel().sum());
        Summing.timeTest("Basic Sum", CHECK, () -> basicSum(la));
        Summing.timeTest("parallelPrefix", CHECK, () -> {
            Arrays.parallelPrefix(la, Long::sum);
            return la[la.length - 1];
        });

    }
}
/**
 *
 5000000050000000
 Array stream sum: 78 ms
 Parallel: 47 ms
 Basic Sum: 66 ms
 parallelPrefix: 163 ms
 */