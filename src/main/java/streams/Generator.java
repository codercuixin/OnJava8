package streams;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/1 10:59
 */
public class Generator implements Supplier<String> {
    Random random = new Random(47);
    char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    @Override
    public String get() {
        return " " + letters[random.nextInt(letters.length)];
    }
    public static void main(String[] args){
        String word = Stream.generate(new Generator()).limit(30).collect(Collectors.joining());
        System.out.println(word);
    }
}
