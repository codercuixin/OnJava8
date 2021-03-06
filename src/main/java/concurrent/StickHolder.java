package concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/5 11:13
 */
public class StickHolder {
    private static class Chopstick{}
    private Chopstick stick = new Chopstick();
    private BlockingQueue<Chopstick> holder = new ArrayBlockingQueue<>(1);
    public StickHolder(){
        putDown();
    }
    public void pickUp(){
        try{
            holder.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void putDown(){
        try{
            holder.put(stick);
        } catch (InterruptedException e) {
           throw new RuntimeException(e);
        }
    }
}
