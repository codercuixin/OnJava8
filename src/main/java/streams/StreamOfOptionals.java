package streams;

import java.util.Optional;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/1 16:08
 */
public class StreamOfOptionals {
    public static void main(String[] args){
        Signal.stream()
                .limit(10)
                .forEach(System.out::println);
        System.out.println("- - -");
        Signal.stream()
                .limit(10)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(System.out::println);
    }
}
