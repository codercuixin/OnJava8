package lowlevel;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/8 16:29
 */
public abstract class IntGenerator {
    private AtomicBoolean cancelled = new AtomicBoolean();
    public abstract int next();
    public void cancel(){
        cancelled.set(true);
    }
    public boolean isCanceled(){
        return cancelled.get();
    }
}
