package streams;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/1 14:39
 */
public class StreamOfRandoms {
    static Random random = new Random(47);
    public static void main(String[] args){
        Stream.of(1, 2, 3, 4, 5)
                .flatMapToInt(i ->  IntStream.concat(random.ints(0, 100).limit(i),
                                IntStream.of(-1)))
                        .forEach(System.out::println);

    }
}
