package concurrent;

import java.util.stream.IntStream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/4 15:58
 */
public class CountingStream {
    public static void main(String[] args){
        System.out.println(IntStream
                .range(0,10)
                .parallel()
                .mapToObj(CountingTask::new)
                .map(ct->ct.call())
                .reduce(0, Integer::sum)
        );

    }
}
