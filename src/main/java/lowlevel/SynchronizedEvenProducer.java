package lowlevel;

import onjava.Nap;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/8 17:34
 */
public class SynchronizedEvenProducer extends IntGenerator{
    private int currentEvenValue = 0;
    @Override
    public synchronized int next() {
        ++currentEvenValue;
        new Nap(0.1);// to raise the likehood of a context switch
        ++currentEvenValue;
        return currentEvenValue;
    }
    public static void main(String[] args){
        EvenChecker.test(new SynchronizedEvenProducer());
    }
}
