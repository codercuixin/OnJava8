package streams;

import static java.util.stream.IntStream.range;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/1 10:57
 */
public class Repeat {
    public static void repeat(int n, Runnable runnable){
        range(0, n).forEach(i -> runnable.run());
    }
}
