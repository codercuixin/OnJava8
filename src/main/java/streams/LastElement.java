package streams;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/1 17:23
 */
public class LastElement {
    public static void main(String[] args){
        OptionalInt last = IntStream.range(10, 20)
                .reduce((n1, n2)->n2);
        System.out.println(last.orElse(-1));
        Optional<String> lastObj = Stream.of("one", "two", "three")
                .reduce((s1, s2)->s2);
        System.out.println(lastObj.orElse("Nothing there"));
    }
}
