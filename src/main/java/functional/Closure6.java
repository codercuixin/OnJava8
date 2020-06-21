package functional;

import java.util.function.IntSupplier;

/**
 * * @Author: cuixin
 * * @Date: 2020/5/29 19:54
 */
public class Closure6 {
    IntSupplier makeFun(int x){
        x++;
        int i=0;
        i++;
        final int finalI = i;
        final int finalX = x;
        return ()->finalI + finalX;
    }
}
