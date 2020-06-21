package concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/5 13:59
 */
public class GuardedIDField implements HasID {
    private static AtomicInteger counter = new AtomicInteger();
    private int id =counter.getAndIncrement();
    @Override
    public int getID() {
        return id;
    }
    public static void main(String[] args){
        IDChecker.test(GuardedIDField::new);
    }
}
