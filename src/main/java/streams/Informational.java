package streams;

import java.io.IOException;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/1 17:26
 */
public class Informational {
    public static void main(String[] args) throws IOException {
        System.out.println(FileToWords.stream("streams/Cheese.dat").count());
        System.out.println(FileToWords.stream("streams/Cheese.dat").min(String.CASE_INSENSITIVE_ORDER).orElse("None"));
        System.out.println(FileToWords.stream("streams/Cheese.dat").max(String.CASE_INSENSITIVE_ORDER).orElse("NONE"));


    }
}
