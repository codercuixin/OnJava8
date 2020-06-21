package streams;

import java.util.stream.Stream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/1 14:36
 */
public class StreamOfStreams {
    public static void main(String[] args){
        Stream.of(1,2,3)
                .map(i-> Stream.of("Gonzo", "Kermit", "Baker"))
                .map(e-> e.getClass().getName())
                .forEach(System.out::println);
    }
}
