package functional;

import java.util.function.IntSupplier;

/**
 * * @Author: cuixin
 * * @Date: 2020/5/29 19:37
 */
public class Closure1 {
    int i;
    IntSupplier makeFun(int x){
        return ()-> x+ i++;
    }
}
