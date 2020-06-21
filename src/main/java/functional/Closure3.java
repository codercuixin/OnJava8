package functional;

import java.util.function.IntSupplier;

/**
 * * @Author: cuixin
 * * @Date: 2020/5/29 19:44
 */
public class Closure3 {
    // 从lambda 表达式引用的本地变量必须是最终变量或实际上的最终变量
    IntSupplier makeFun(int x){
        int i=0;
//        return ()->x+i++;
        return ()->x+i;
    }
}
