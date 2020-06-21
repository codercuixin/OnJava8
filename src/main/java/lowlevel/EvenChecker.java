package lowlevel;

import onjava.TimeAbort;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/8 16:46
 */
public class EvenChecker implements Runnable{
    private IntGenerator generator;
    private final int id;
    public EvenChecker(IntGenerator generator, int id){
        this.generator = generator;
        this.id = id;
    }
    @Override
    public void run() {
        while (!generator.isCanceled()){
            int val = generator.next();
            if(val % 2 !=0){
                System.out.println(val+" not even!");
                generator.cancel();
            }
        }
    }
    public static void test(IntGenerator gp, int count){
        List<CompletableFuture<Void>> checkers = IntStream.range(0, count)
                .mapToObj(i-> new EvenChecker(gp, i))
                .map(CompletableFuture::runAsync)
                .collect(Collectors.toList());
        checkers.forEach(CompletableFuture::join);
    }

    public static void test(IntGenerator gp){
        new TimeAbort(4, "No odd numbers discovered");
        test(gp, 10);
    }
}
