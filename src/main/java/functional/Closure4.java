package functional;

import java.util.function.IntSupplier;

/**
 * * @Author: cuixin
 * * @Date: 2020/5/29 19:50
 */
public class Closure4 {
    IntSupplier makeFun(final int x){
        final int i = 0;
        return ()-> x+i;
    }
}
