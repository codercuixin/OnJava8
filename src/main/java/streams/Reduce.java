package streams;

import java.util.Random;
import java.util.stream.Stream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/1 16:57
 */
public class Reduce {
    public static void main(String[] args) {
        Stream.generate(Frobnitz::supply)
                .limit(10)
                .peek(System.out::println)
                .reduce((fr0, fr1) -> fr0.size < 50 ? fr0 : fr1)
                .ifPresent(frobnitz -> {System.out.println();
                    System.out.println(frobnitz);
                });
    }
}

class Frobnitz {
    int size;

    Frobnitz(int sz) {
        size = sz;
    }

    @Override
    public String toString() {
        return "Frobnitz{" +
                "size=" + size +
                '}';
    }

    //Generator
    static Random rand = new Random(47);
    static final int BOUND = 100;

    static Frobnitz supply() {
        return new Frobnitz(rand.nextInt(BOUND));
    }
}