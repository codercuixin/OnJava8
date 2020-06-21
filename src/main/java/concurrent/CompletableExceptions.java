package concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/5 9:58
 */
public class CompletableExceptions {
    static CompletableFuture<Breakable>
        test(String id, int failcount){
        return CompletableFuture.completedFuture(new Breakable(id, failcount))
                .thenApply(Breakable::work)
                .thenApply(Breakable::work)
                .thenApply(Breakable::work)
                .thenApply(Breakable::work);
    }
    public static void main(String[] args){
        //Exceptions don't appear
        test("A", 1);
        test("B", 2);
        test("C", 3);
        test("D", 4);
        test("E", 5);
        //...until you try to fetch the value
        try{
            test("F", 2).get();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        //test for exceptions
        System.out.println(test("G",2).isCompletedExceptionally());
        //counts as "done"
        System.out.println(test("H",2).isDone());
        //Force an exception
        CompletableFuture<Integer> cfi = new CompletableFuture<>();
        System.out.println("Done?"+cfi.isDone());
        cfi.completeExceptionally(new RuntimeException("forced"));
        try {
            cfi.get();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
