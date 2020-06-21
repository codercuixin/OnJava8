package concurrent;

import onjava.Timer;

import java.util.concurrent.CompletableFuture;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/4 17:23
 */
public class CompletableApplyChained {
    public static void main(String[] args){
        Timer timer = new Timer();
        CompletableFuture<Machina> cf  = CompletableFuture.completedFuture(new Machina(0))
                .thenApply(Machina::work)
                .thenApply(Machina::work)
                .thenApply(Machina::work)
                .thenApply(Machina::work);
        System.out.println(timer.duration());
    }
}
