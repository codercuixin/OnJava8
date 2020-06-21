package lowlevel;

import java.util.function.IntSupplier;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/8 18:57
 */
public abstract class IntTestable implements Runnable, IntSupplier {
    abstract void eventIncrement();
    @Override
    public void run() {
        while (true){
            eventIncrement();
        }
    }
}
