package lowlevel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/8 15:33
 */
public class ExceptionThread implements Runnable{
    @Override
    public void run() {
        throw new RuntimeException();
    }
    public static void main(String[] args){
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(new ExceptionThread());
        es.shutdown();
    }
}
