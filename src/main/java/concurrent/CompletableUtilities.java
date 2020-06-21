package concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/4 17:36
 */
public class CompletableUtilities {
    public static void showr(CompletableFuture<?> c){
        try {
            System.out.println(c.get());
        } catch (InterruptedException  | ExecutionException e) {
          throw new RuntimeException(e);
        }
    }

    public static void voidr(CompletableFuture<Void> c){
        try {
           c.get();
        } catch (InterruptedException  | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
