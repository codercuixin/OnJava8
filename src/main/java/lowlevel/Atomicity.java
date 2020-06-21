package lowlevel;

import onjava.TimeAbort;

import java.util.concurrent.CompletableFuture;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/8 18:59
 */
public class Atomicity {
    public static void test(IntTestable it){
        new TimeAbort(4, "No failures found");
        CompletableFuture.runAsync(it);
        while (true){
            int val = it.getAsInt();
            if(val %2 != 0){
                System.out.println("failed with: "+val);
                System.exit(0);
            }
        }
    }
}
