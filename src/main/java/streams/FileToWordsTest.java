package streams;

import java.io.IOException;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/1 14:51
 */
public class FileToWordsTest {
    public static void main(String[] args) throws IOException {
        FileToWords.stream("streams/Cheese.dat")
                .limit(7)
                .forEach(s->System.out.format("%s ", s));
        System.out.println();
        FileToWords.stream("streams/Cheese.dat")
                .skip(7)
                .limit(2)
                .forEach(s->System.out.format("%s ", s));
    }
}
