package streams;

import java.io.IOException;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/1 17:29
 */
public class NumberStreamInfo {
    public static void main(String[] args) throws IOException {
        System.out.println(RandInts.rands().average().getAsDouble());
        System.out.println(RandInts.rands().max().getAsInt());
        System.out.println(RandInts.rands().min().getAsInt());
        System.out.println(RandInts.rands().sum());
        System.out.println(RandInts.rands().summaryStatistics());
    }
}
