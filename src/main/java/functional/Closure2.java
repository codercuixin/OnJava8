package functional;

import java.util.function.IntSupplier;

/**
 * * @Author: cuixin
 * * @Date: 2020/5/29 19:43
 */
public class Closure2 {
    IntSupplier makeFun(int x){
        int i=0;
        return ()-> x+i;
    }
}
