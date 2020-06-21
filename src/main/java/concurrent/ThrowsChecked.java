package concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/5 10:48
 */
public class ThrowsChecked {
    class Checked extends Exception{ }
    static ThrowsChecked nochecked(ThrowsChecked tc){
        return tc;
    }
    static ThrowsChecked withchecked(ThrowsChecked tc) throws Checked{
        return tc;
    }

    static void testStream(){
        Stream<ThrowsChecked> throwsCheckedStream = Stream.of(new ThrowsChecked())
                .map(ThrowsChecked::nochecked)
                .map(tc -> {
                    try {
                        return withchecked(tc);
                    } catch (Checked checked) {
                        checked.printStackTrace();
                        return null;
                    }
                })
                .map(tc -> {
                    try {
                        return withchecked(tc);
                    } catch (Checked e) {
                        throw new RuntimeException(e);
                    }
                });
    }
    static void testCompletableFuture(){
        CompletableFuture.completedFuture(new ThrowsChecked())
                .thenApply(ThrowsChecked::nochecked)
                .thenApply(tc1 -> {
                    try {
                        return withchecked(tc1);
                    } catch (Checked checked) {
                        checked.printStackTrace();
                        return null;
                    }
                })
                .thenApply(tc->{
                    try{
                        return withchecked(tc);
                    }catch (Checked e){
                        throw new RuntimeException(e);
                    }
                });
    }
}
