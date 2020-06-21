package lowlevel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/8 15:27
 */
public class SwallowedException {
    public static void main(String[] args){
        ExecutorService exec = Executors.newSingleThreadExecutor();
        exec.submit(()->{throw new RuntimeException();});
        exec.shutdown();
    }
}
