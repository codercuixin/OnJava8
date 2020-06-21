package functional;

import java.util.function.IntSupplier;

/**
 * * @Author: cuixin
 * * @Date: 2020/5/29 20:09
 */
public class AnonymousClosure {
    IntSupplier makeFun(int x){
        int i=0;
        return new IntSupplier() {
            @Override
            public int getAsInt() {
                return x + i;
            }
        };
    }
}
