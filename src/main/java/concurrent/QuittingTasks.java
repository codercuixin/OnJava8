package concurrent;

import onjava.Nap;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/4 16:33
 */
public class QuittingTasks {
    public static final int COUNT = 150;
    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<QuittableTask> tasks = IntStream.range(0, COUNT)
                .mapToObj(QuittableTask::new)
                .peek(qt->{ executorService.execute(qt);})
                .collect(Collectors.toList());
        new Nap(1);
        for (QuittableTask task : tasks) {
            task.quit();
        }
        executorService.shutdown();
    }
}
