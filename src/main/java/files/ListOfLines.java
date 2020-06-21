package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/9 16:58
 */
public class ListOfLines {
    public static void main(String[] args) throws IOException {
        Files.readAllLines(Paths.get("streams/Cheese.dat"))
                .stream()
                .filter(line->!line.startsWith("//"))
                .map(line->line.substring(0, line.length()/2))
                .forEach(System.out::println);
    }
}
