package lowlevel;

import onjava.Nap;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/8 20:03
 */
public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();
    public void untimed(){
        boolean captured = lock.tryLock();
        try{
            System.out.println("TryLock(): "+captured);
        }finally {
            if(captured){
                lock.unlock();
            }
        }
    }
    public void timed(){
        boolean captured = false;
        try{
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        try{
            System.out.println("tryLock(2, TimeUnit.SECONDS): "+captured);
        }finally {
            if(captured){
                lock.unlock();
            }
        }
    }
    public static void main(String[] args){
        final AttemptLocking al = new AttemptLocking();
        al.untimed();
        al.timed();
        CompletableFuture.runAsync(()->{
            al.lock.lock();
            System.out.println("acquired");
        });
        new Nap(0.1);
        al.untimed();
        al.timed();
    }
}
