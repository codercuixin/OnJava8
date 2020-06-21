package lowlevel;

import onjava.Nap;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/8 19:35
 */
public abstract class SynchronizedComparison {
   static void test(Guarded g){
       List<CompletableFuture<Void>> callers = Stream.of(new Caller(g),
               new Caller(g),
               new Caller(g),
               new Caller(g))
               .map(CompletableFuture::runAsync)
               .collect(Collectors.toList());
       for (CompletableFuture<Void> caller : callers) {
           caller.join();
       }
       System.out.println(g);
   }
   public static void main(String[] args){
       test(new CriticalSection());
       test(new SynchronizedMethod());
   }
}
abstract class Guarded{
    AtomicLong callCount = new AtomicLong();
    public abstract void method();

    @Override
    public String toString() {
        return getClass().getSimpleName()+": "+callCount.get();
    }
}
class SynchronizedMethod extends Guarded{

    @Override
    public synchronized void method() {
        new Nap(0.01);
        callCount.incrementAndGet();
    }
}
class CriticalSection extends Guarded{
    @Override
    public void method() {
        new Nap(0.01);
        synchronized (this){
            callCount.incrementAndGet();
        }
    }
}
class Caller implements Runnable{
    private Guarded g;
    private AtomicLong successfulCalls = new AtomicLong();
    private AtomicBoolean stop = new AtomicBoolean(false);
    Caller(Guarded g){
        this.g = g;
    }
    @Override
    public void run() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                stop.set(true);
            }
        }, 2500);
        while (!stop.get()){
            g.method();
            successfulCalls.getAndIncrement();
        }
        System.out.println("-> "+successfulCalls.get());
    }
}
