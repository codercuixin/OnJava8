package lowlevel;

import onjava.Nap;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/8 15:06
 */
public class ThreadSize {
    static class Dummy extends Thread{
        @Override
        public void run(){
            new Nap(100);
        }
    }
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        int count = 0;
        try{
            while (true){
                exec.execute(new Dummy());
                count++;
            }
        }catch (Error e){
            System.out.println(e.getClass().getSimpleName()+": "+count);
            System.exit(1);
        }finally {
            exec.shutdown();
        }
    }
}
