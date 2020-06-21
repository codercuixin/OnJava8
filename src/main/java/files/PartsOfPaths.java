package files;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/9 13:28
 */
public class PartsOfPaths {
    public static void main(String[] args){
        System.out.println(System.getProperty("os.name"));
        Path p  = Paths.get("files/PartsOfPath.java").toAbsolutePath();
        for(int i=0; i<p.getNameCount(); i++){
            System.out.println(p.getName(i));
        }
        System.out.println("ends with '.java': "+p.endsWith(".java"));
        for(Path pp: p){
            System.out.print(pp+": ");
            System.out.print(p.startsWith(pp)+" : ");
            System.out.println(p.endsWith(pp));
        }
        System.out.println("Starts with " + p.getRoot() + " " + p.startsWith(p.getRoot()));
    }
}
