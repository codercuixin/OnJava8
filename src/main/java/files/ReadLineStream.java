package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/9 17:14
 */
public class ReadLineStream {
    public static void main(String[] args) throws IOException {
        Files.lines(Paths.get("files/PathInfo.java"))
                .skip(13)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
