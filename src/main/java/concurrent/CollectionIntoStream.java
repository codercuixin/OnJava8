package concurrent;

import onjava.Rand;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/4 14:13
 */
public class CollectionIntoStream {
    public static void main(String[] args){
        List<String> strings = Stream.generate(new Rand.String(5))
                .limit(10).collect(Collectors.toList());
        strings.forEach(System.out::println);
        String result = strings.stream().map(String::toUpperCase)
                .map(s->s.substring(2))
                .reduce(":", (s1, s2)->s1+s2);
        System.out.println(result);
    }
}
