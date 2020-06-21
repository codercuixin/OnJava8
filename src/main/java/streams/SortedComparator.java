package streams;

import java.io.IOException;
import java.util.Comparator;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/1 13:36
 */
public class SortedComparator {
    public static void main(String[] args) throws IOException {
        FileToWords.stream("streams/Cheese.dat")
                .skip(10)
                .limit(10)
                .sorted(Comparator.reverseOrder())
                .map(w->w+" ")
                .forEach(System.out::print);
    }

}
