package streams;

import java.util.stream.Stream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/1 11:05
 */
public class Bubbles {
    public static  void main(String[] args){
        Stream.generate(Bubble::bubbler)
                .limit(3)
                .forEach(System.out::println);
    }
}
