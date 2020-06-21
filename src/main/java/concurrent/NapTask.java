package concurrent;

import onjava.Nap;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/4 14:47
 */
public class NapTask implements Runnable {
    final int id;
    public NapTask(int id){
        this.id = id;
    }
    @Override
    public void run() {
        new Nap(0.1);
        System.out.println(this + " "+Thread.currentThread().getName());
    }

    @Override
    public String toString() {
        return "NapTask[" + id + "]";
    }
}
