package files;

import onjava.RmDir;

import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/9 15:20
 */
public class Directories {
    static Path test = Paths.get("test");
    static String seq = FileSystems.getDefault().getSeparator();
    static List<String> parts = Arrays.asList("foo", "bar", "baz", "bag");
    static Path makeVariant(){
        Collections.rotate(parts, 1);
        return Paths.get("test", String.join(seq, parts));
    }
    static void refreshTestDir() throws IOException {
        if(Files.exists(test)){
            RmDir.rmdir(test);
        }
        if(!Files.exists(test)){
            Files.createDirectory(test);
        }
    }

    public static void main(String[] args) throws IOException {
        refreshTestDir();
        Files.createFile(test.resolve("Hello.txt"));
        Path variant = makeVariant();
        //throw exception(two many levels)
        try {
            Files.createDirectory(variant);
        }catch (Exception e){
            System.out.println("Nope, that doesn't work.");
        }
        populateTestDir();
        Path tempDir = Files.createTempDirectory(test, "DIR_");
        Files.createTempFile(tempDir, "pre", ".non");
        Files.newDirectoryStream(test)
                .forEach(System.out::println);
        System.out.println("***********");
        Files.walk(test).forEach(System.out::println);
    }
    static void populateTestDir() throws IOException {
        for(int i=0; i< parts.size(); i++){
            Path variant  = makeVariant();
            if(!Files.exists(variant)){
                Files.createDirectories(variant);
                Files.copy(Paths.get("files","Directories.java"), variant.resolve("File.txt"));
                Files.createTempFile(variant,null, null);
            }
        }
    }


}
