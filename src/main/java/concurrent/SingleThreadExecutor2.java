package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/4 14:58
 */
public class SingleThreadExecutor2 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        IntStream.range(0, 10)
                .mapToObj(NapTask::new)
                .forEach(exec::execute);
        System.out.println("All tasks submitted");
        exec.shutdown();
//        exec.submit(new NapTask(11));
    }
}
