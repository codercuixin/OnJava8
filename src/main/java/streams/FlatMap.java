package streams;

import java.util.stream.Stream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/1 14:38
 */
public class FlatMap {
    public static void main(String[] args){
        Stream.of(1, 2, 3)
                .flatMap(i -> Stream.of("Gonzo", "Fozzie", "Baker"))
                .forEach(System.out::println);
    }
}
