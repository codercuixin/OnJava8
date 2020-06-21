package streams;

import java.io.IOException;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/1 13:30
 */
public class Peeking {
    public static void main(String[] args) throws IOException {
        FileToWords.stream("streams/Cheese.dat")
                .skip(21)
                .limit(4)
                .map(w->w+" ")
                .peek(System.out::print)
                .map(String::toUpperCase)
                .peek(System.out::print)
                .map(String::toLowerCase)
                .forEach(System.out::print);
    }
}
