package concurrent;

import onjava.Timer;

import java.util.function.LongSupplier;
import java.util.stream.LongStream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/4 11:23
 */
public class Summing {
    static void timeTest(String id, long checkValue, LongSupplier operation) {
        System.out.print(id + ": ");
        Timer timer = new Timer();
        long result = operation.getAsLong();
        if (result == checkValue) {
            System.out.println(timer.duration() + " ms");
        } else {
            System.out.format("result: %d%ncheckValue:%d%n", result, checkValue);
        }
    }
    public static final int SZ = 100000000;
    /**
     * Gauss's formula
     */
    public static final long CHECK = (long)SZ *((long)SZ + 1)/2;

    public static  void main(String[] args){
        System.out.println(CHECK);
        timeTest("Sum stream", CHECK, ()-> LongStream.rangeClosed(0, SZ).sum());
        timeTest("Sum stream parallel", CHECK, ()->LongStream.rangeClosed(0, SZ).parallel().sum());
        timeTest("Sum Iterated", CHECK, ()->LongStream.iterate(0, i->i+1).limit(SZ+1).sum());
        timeTest("Sum iterated parallel", CHECK, ()->LongStream.iterate(0, i->i+1).parallel()
                .limit(SZ+1).sum());
    }
}
/*
5000000050000000
Sum stream: 191 ms
Sum stream parallel: 50 ms
Sum Iterated: 241 ms
Sum iterated parallel: 2046 ms
 */