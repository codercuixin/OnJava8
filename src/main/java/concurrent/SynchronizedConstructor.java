package concurrent;

class SyncConstrucor implements HasID{
    private final int id;
    private static Object  constrcutorLock = new Object();
    SyncConstrucor(SharedArg sa){
        synchronized (constrcutorLock){
           id = sa.get();
        }
    }

    @Override
    public int getID() {
        return id;
    }
}

/**
 * * @Author: cuixin
 * * @Date: 2020/6/5 14:26
 */
public class SynchronizedConstructor {
   public static void main(String[] args){
       Unsafe unsafe = new Unsafe();
       IDChecker.test(()->new SyncConstrucor(unsafe));
   }
}
