package files;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/9 11:47
 */
public class PathInfo {
    static void show(String id, Object p){
        System.out.println(id+": "+p);
    }
    static void info(Path p){
        show("toString", p);
        show("Exsits", Files.exists(p));
        show("RegularFile", Files.isRegularFile(p));
        show("Directory", Files.isDirectory(p));
        show("Absolute", p.isAbsolute());
        show("FileName", p.getFileName());
        show("Parent", p.getParent());
        show("Root", p.getRoot());
        System.out.println("********************");
    }
    public static void main(String[] args){
        System.out.println(System.getProperty("os.name"));
        info(Paths.get("C:", "path", "to", "nowhere", "NoFile.txt"));
        Path p = Paths.get("files/PathInfo.java");
        info(p);
         Path ap = p.toAbsolutePath();
         info(ap);
         info(ap.getParent());
         try{
             info(p.toRealPath());
         } catch (IOException e) {
             e.printStackTrace();
         }
         URI u = p.toUri();
         System.out.println("URI: "+u);
         Path puri = Paths.get(u);
         System.out.println(Files.exists(puri));
         //don't be fooled
         File f = ap.toFile();
    }
}
