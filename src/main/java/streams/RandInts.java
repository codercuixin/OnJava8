package streams;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/1 16:14
 */
public class RandInts {
    private static int[] rints
            = new Random(47).ints(0, 100)
            .limit(100).toArray();

    public static IntStream rands() {
        return Arrays.stream(rints);
    }
}
