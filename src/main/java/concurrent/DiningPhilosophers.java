package concurrent;

import onjava.Nap;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/5 11:21
 */
public class DiningPhilosophers {
    private StickHolder[] sticks;
    private Philosopher[] philosophers;
    public DiningPhilosophers(int n){
        sticks = new StickHolder[n];
        Arrays.setAll(sticks,  i->new StickHolder());
        philosophers = new Philosopher[n];
        Arrays.setAll(philosophers, i->new Philosopher(i, sticks[i], sticks[(i+1)%n]));
        //fix by reversing stick order for this one
        philosophers[1] = new Philosopher(1, sticks[2], sticks[1]);
        Arrays.stream(philosophers)
                .forEach(CompletableFuture::runAsync);
    }
    public static void main(String[] args){
        //returns right away
        new DiningPhilosophers(5);
        //keep main() from exiting
        new Nap(30, "shutdown");
    }
}
