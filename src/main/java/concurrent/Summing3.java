package concurrent;

import java.util.Arrays;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/4 13:23
 */
public class Summing3 {
    static long basicSum(Long[] ia){
        long sum = 0;
        int size = ia.length;
        for(int i=0; i<size; i++){
            sum += ia[i];
        }
        return sum;
    }

    public static final int SZ = 100000000;
    public static final long CHECK = (long)SZ * ((long) SZ +1) / 2;
    public static void main(String[] args){
        System.out.println(CHECK);
        Long[] al = new Long[SZ+1];
        Arrays.parallelSetAll(al, i->(long)i);
        Summing.timeTest("Long Array stream reduce", CHECK, ()->
                Arrays.stream(al).reduce(0L, Long::sum));
        Summing.timeTest("Long basic sum", CHECK, ()->basicSum(al));
        Summing.timeTest("Long parallelPrefix", CHECK, ()->{
            Arrays.parallelPrefix(al, Long::sum);
            return al[al.length-1];
        });
    }
}
/**
 *5000000050000000
 * Long Array stream reduce: 43047 ms
 * Long basic sum: 210 ms
 * Long parallelPrefix: 94061 ms
 */
