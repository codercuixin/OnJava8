package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/1 11:21
 */
public class FileToWordsBuilder {
    Stream.Builder<String> builder = Stream.builder();
    public FileToWordsBuilder(String filePath) throws IOException {
        Files.lines(Paths.get(filePath))
                .skip(1)
                .forEach(line -> {
                    for(String w: line.split("[ .?,]+")){
                        builder.add(w);
                    }
                });
    }
    Stream<String> stream(){
        return builder.build();
    }
    public static void main(String[] args) throws IOException {
        new FileToWordsBuilder("streams/Cheese.dat").stream()
                .limit(7)
                .map(w->w+" ")
                .forEach(System.out::print);
    }
}
