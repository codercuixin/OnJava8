package lowlevel;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/8 19:28
 */
public class AtomicEvenProducer extends IntGenerator {
    private AtomicInteger currentEvenValue = new AtomicInteger(0);

    @Override
    public int next() {
        return currentEvenValue.addAndGet(2);
    }
    public static void main(String[] args){
        EvenChecker.test(new AtomicEvenProducer());
    }
}
