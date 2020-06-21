package functional;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * * @Author: cuixin
 * * @Date: 2020/5/29 20:24
 */
public class PredicateComposition {
    static Predicate<String>
            p1 = s -> s.contains("bar"),
            p2 = s -> s.length() < 5,
            p3 = s -> s.contains("foo"),
            p4 = p1.negate().and(p2).or(p3);

    public static void main(String[] args) {
        Stream.of("bar", "foobar", "foobarz", "fongopuckey")
                .filter(p4)
                .forEach(System.out::println);
    }

}
