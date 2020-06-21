package streams;

import java.io.IOException;
import java.util.ArrayList;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/1 16:49
 */
public class SpecialCollector {
    public static void main(String[] args) throws IOException {
        ArrayList<String> words = FileToWords.stream("streams/Cheese.dat")
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        words.stream().filter(s->s.equals("cheese"))
                .forEach(System.out::println);

    }
}
