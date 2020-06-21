package lowlevel;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/8 18:01
 */
public class ReOrdering implements Runnable {
    int one, two, three, four, five, six;
    volatile int VOLATILE;
        @Override
    public void run() {
        one = 1;
        two = 2;
        three = 3;
        VOLATILE = 92;
        int x = four;
        int y = five;
        int z = six;
    }
}
