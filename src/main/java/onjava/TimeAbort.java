package onjava;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/8 16:51
 */
public class TimeAbort {
    private volatile boolean restart = true;
    public TimeAbort(double t, String msg){
        CompletableFuture.runAsync(()->{
           try{
               while (restart){
                   restart = false;
                   TimeUnit.MILLISECONDS.sleep((int)(1000*t));
               }
           } catch (InterruptedException e) {
               throw new  RuntimeException(e);
           }
           System.out.println(msg);
           System.exit(0);
        });

    }
    public TimeAbort(double t){
        this(t, "TimeAbort"+t);
    }
    public void restart(){
        restart = true;
    }
}
