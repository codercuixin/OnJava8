package onjava;

import java.util.concurrent.TimeUnit;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/4 11:11
 */
public class Timer {
    private long start = System.nanoTime();
    public long duration(){
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start);
    }
    public static long duration(Runnable test){
        Timer timer = new Timer();
        test.run();;
        return timer.duration();
    }
}
