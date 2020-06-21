package concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/4 15:52
 */
public class Futures {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> f = executorService.submit(new CountingTask(99));
        System.out.println(f.get());
        executorService.shutdown();
    }
}
