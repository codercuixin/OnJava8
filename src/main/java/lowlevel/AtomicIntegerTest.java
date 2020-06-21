package lowlevel;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/8 19:25
 */
public class AtomicIntegerTest extends IntTestable{
    private AtomicInteger i = new AtomicInteger(0);

    @Override
    void eventIncrement() {
        i.addAndGet(2);
    }

    @Override
    public int getAsInt() {
        return i.get();
    }

    public static void main(String[] args){
        Atomicity.test(new AtomicIntegerTest());
    }
}
