package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/4 15:01
 */
public class MoreTasksAfterShutdown {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        exec.execute(new NapTask(1));
        exec.shutdown();
        try {
            exec.submit(new NapTask(99));
        } catch (RejectedExecutionException e) {
            e.printStackTrace();
        }
    }
}
