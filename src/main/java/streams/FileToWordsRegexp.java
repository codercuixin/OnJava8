package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/1 13:21
 */
public class FileToWordsRegexp {
    private String all;
    public FileToWordsRegexp(String filePath) throws IOException {
        all = Files.lines(Paths.get(filePath))
                .skip(1)
                .collect(Collectors.joining(" "));
    }
    public Stream<String> stream(){
        return Pattern.compile("[ .,?]+").splitAsStream(all);
    }

    public static void main(String[] args) throws IOException {
        FileToWordsRegexp fw = new FileToWordsRegexp("streams/Cheese.dat");
        fw.stream().limit(7)
                .map(w -> w+" ")
                .forEach(System.out::print);
        fw.stream().skip(7).limit(2).map(w->w+" ")
                .forEach(System.out::print);

    }
}
