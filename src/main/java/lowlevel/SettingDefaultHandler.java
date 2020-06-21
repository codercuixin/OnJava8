package lowlevel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/8 15:46
 */
public class SettingDefaultHandler {
    public static void main(String[] args){
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(new ExceptionThread());
        es.shutdown();
    }
}
