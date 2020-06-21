package streams;

import java.util.stream.Stream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/1 11:03
 */
public class Duplicator {
    public static void main(String[] args){
        Stream.generate(()->  "duplicate")
                .limit(3)
                .forEach(System.out::println);
    }
}
