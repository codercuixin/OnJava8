package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class NotRunnable{
    public void go(){
        System.out.println("NotRunnable");
    }
}
class NotCallable{
    public Integer get(){
        System.out.println("NotCallable");
        return 1;
    }
}
/**
 * * @Author: cuixin
 * * @Date: 2020/6/4 16:04
 */
public class LambdasAndMethodReferences {
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(()->System.out.println("Lambda1"));
        exec.execute(new NotRunnable()::go);
        exec.submit(()->{
            System.out.println("Lambda2");
            return 1;
        });
        exec.submit(new NotCallable()::get);
        exec.shutdown();
    }
}
