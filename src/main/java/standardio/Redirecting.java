package standardio;

import java.io.*;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/23 16:32
 */
public class Redirecting {
    public static void main(String[] args){
        PrintStream console = System.out;
        try(BufferedInputStream in = new BufferedInputStream(new FileInputStream("standardio/Redirecting.java"));
            PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("standardio/Redirecting.txt")))
        ){
            System.setIn(in);
            System.setOut(out);
            System.setErr(out);
            new BufferedReader(new InputStreamReader(System.in))
                    .lines()
                    .forEach(System.out::println);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        finally {
            System.setOut(console);
        }
    }
}
