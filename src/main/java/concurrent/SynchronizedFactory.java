package concurrent;
class SyncFactory implements HasID{
    private final int id;
    private SyncFactory(SharedArg sa){
        id = sa.get();
    }

    @Override
    public int getID() {
        return id;
    }
    public static synchronized SyncFactory factory(SharedArg sa){
        return new SyncFactory(sa);
    }
}
/**
 * * @Author: cuixin
 * * @Date: 2020/6/5 14:32
 */
public class SynchronizedFactory {
    public static void main(String[] args){
        Unsafe unsafe = new Unsafe();
        IDChecker.test(()->SyncFactory.factory(unsafe));
    }
}
