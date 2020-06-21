package files;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/9 17:17
 */
public class StreamInAndOut {
    public static void main(String[] arg) {
        try (Stream<String> input = Files.lines(Paths.get("files/StreamInAndOut.java"));
             PrintWriter output = new PrintWriter("StreamInAndOut.txt")) {
            input.map(String::toUpperCase)
                    .forEachOrdered(output::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
