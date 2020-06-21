package functional;

import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

/**
 * * @Author: cuixin
 * * @Date: 2020/5/29 20:40
 */
public class CurriedIntAdd {
    public static void main(String[] args){
        IntFunction<IntUnaryOperator>
                curriedIntAdd = a->b ->a +b;
        IntUnaryOperator add4 = curriedIntAdd.apply(4);
        System.out.println(add4.applyAsInt(5));
    }
}
