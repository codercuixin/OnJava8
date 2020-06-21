package functional;

import java.util.function.Function;
import java.util.function.IntToDoubleFunction;

/**
 * * @Author: cuixin
 * * @Date: 2020/5/29 18:03
 */
public class FunctionWithWrapped {
    public static void main(String[] args){
        Function<Integer, Double> fid = i->(double)i;
        IntToDoubleFunction fid2 = i->i;

    }
}
