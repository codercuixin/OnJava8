package lowlevel;

import onjava.Nap;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/8 19:59
 */
public class MutextEvenProducer extends IntGenerator {
    private int currentEvenValue = 0;
    private Lock lock = new ReentrantLock();
    @Override
    public int next() {
        lock.lock();
        try{
            ++currentEvenValue;
            new Nap(0.1);
            ++currentEvenValue;
            return currentEvenValue;
        }finally {
            lock.unlock();
        }
    }
    public static void main(String[] args){
        EvenChecker.test(new MutextEvenProducer());
    }
}
