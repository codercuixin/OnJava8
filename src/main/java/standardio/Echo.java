package standardio;

import onjava.TimeAbort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/23 16:24
 */
public class Echo {
    public static void main(String[] args){
        TimeAbort abort = new TimeAbort(2);
        new BufferedReader(new InputStreamReader(System.in))
                .lines()
                .peek(ln->abort.restart())
                .forEach(System.out::println);
    }
}
