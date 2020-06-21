package concurrent;

import java.util.Arrays;

import static concurrent.Summing3.CHECK;
import static concurrent.Summing3.SZ;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/4 13:57
 */
public class Summing4 {
    public static void main(String[] args) {
        System.out.println(CHECK);
        Long[] al = new Long[SZ + 1];
        Arrays.parallelSetAll(al, i -> (long) i);
        Summing.timeTest("Long parallel",
                CHECK, () ->
                        Arrays.stream(al).parallel().reduce(0L,
                                Long::sum));
    }
}
/*
5000000050000000
Long parallel: 43102 ms
 */