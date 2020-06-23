package standardio;

import java.io.PrintWriter;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/23 16:30
 */
public class ChangeSystemOut {
    public static void main(String[] args){
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("hello world");
    }
}
