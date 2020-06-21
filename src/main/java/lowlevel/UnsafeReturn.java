package lowlevel;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/8 19:01
 */
public class UnsafeReturn extends IntTestable {
    private int i=0;
    @Override
    public synchronized void eventIncrement() {
        i++;
        i++;
    }

    @Override
    public int getAsInt() {
        return i;
    }

    public static void main(String[] args){
        Atomicity.test(new UnsafeReturn());
    }
}
