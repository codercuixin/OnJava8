package concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/4 17:03
 */
public class CompletedMachina {
    public static void main(String[] args){
        CompletableFuture<Machina> cf = CompletableFuture.completedFuture(new Machina(0));
        try{
            Machina m = cf.get();
        }catch (InterruptedException| ExecutionException e){
            throw new RuntimeException(e);
        }
    }
}
