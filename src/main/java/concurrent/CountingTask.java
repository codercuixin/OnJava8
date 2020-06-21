package concurrent;

import java.util.concurrent.Callable;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/4 15:46
 */
public class CountingTask implements Callable<Integer> {
    final int id;
    public CountingTask(int id){this.id = id;}
    @Override
    public Integer call()  {
        Integer val = 0;
        for(int i =0; i<100; i++){
            val++;
        }
        System.out.println(id+" "+Thread.currentThread().getName()+" "+val);
        return val;
    }

}
