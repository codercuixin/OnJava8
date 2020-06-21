package functional;

import java.util.function.BiConsumer;

/**
 * * @Author: cuixin
 * * @Date: 2020/5/29 17:56
 */
public class BiConsumerPermutations {
    static BiConsumer<Integer, Double> bicId = (i,d) ->{
        System.out.format("%d, %f%n", i, d);
    };
    static BiConsumer<Double, Long> bicDL = (d, l)->{
        System.out.format("%f, %d%n", d, l);
    };
    static BiConsumer<Long, Integer> bicLi = (l,i)->{
        System.out.format("%d %d%n", l, i);
    };
    public static void main(String[] args){
        bicId.accept(1, 2.0);
        bicDL.accept(2.0, 1L);
        bicLi.accept(1L, 1);
    }
}
