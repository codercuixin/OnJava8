package streams;

import java.util.stream.Stream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/1 14:27
 */
public class FunctionMap3 {
    public static void main(String[] args){
        Stream.of("5", "7", "9")
                .mapToInt(Integer::parseInt)
                .forEach(n -> System.out.format("%d ", n));
        System.out.println();
        Stream.of("17", "19", "23")
                .mapToLong(Long::parseLong)
                .forEach(n->System.out.format("%d ", n));
        System.out.println();
        Stream.of("17", "1.8", "2.3")
                .mapToDouble(Double::parseDouble)
                .forEach(n->System.out.format("%f ", n));

    }
}
