package lowlevel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/8 15:38
 */
public class CaptureUncaughtException {
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());
        exec.shutdown();
    }
}
class ExceptionThread2 implements Runnable{
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println(" run() by "+ t.getName());
        System.out.println(" eh = " + t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}
class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught thread="+t.getName()+", throwable="+e);
    }
}
class HandlerThreadFactory implements ThreadFactory{
    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this+" creating new Thread");
        Thread t = new Thread(r);
        System.out.println("created "+t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        return t;
    }
}
