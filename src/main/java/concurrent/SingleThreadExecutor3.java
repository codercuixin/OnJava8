package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/4 15:42
 */
public class SingleThreadExecutor3 {
    public static void main(String[] args){
        ExecutorService exec = Executors.newSingleThreadExecutor();
        IntStream.range(0, 10)
                .mapToObj(InterferingTask::new)
                .forEach(exec::execute);
        exec.shutdown();
    }
}
