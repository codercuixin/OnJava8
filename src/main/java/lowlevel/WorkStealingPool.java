package lowlevel;

import onjava.Nap;
import onjava.Rand;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

class ShowThread implements Runnable {
    Random random = new Random(47);
    @Override
    public void run() {
        new Nap(random.nextDouble());
        System.out.println(Thread.currentThread().getName());
    }
}
/**
 * * @Author: cuixin
 * * @Date: 2020/6/8 15:18
 */
public class WorkStealingPool {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService exec = Executors.newWorkStealingPool();
        IntStream.range(0, 100)
                .mapToObj(n-> new ShowThread())
                .forEach(exec:: execute);
        exec.awaitTermination(100000, TimeUnit.SECONDS);
    }
}
