package functional;

import java.util.function.BiConsumer;

class In1{}
class In2{}
/**
 * * @Author: cuixin
 * * @Date: 2020/5/29 17:17
 */
public class MethodConversion {
    static void accept(In1 in1, In2 in2){
        System.out.println("accept()");
    }
    static void someOtherName(In1 in1, In2 in2){
        System.out.println("omeOtherName()");
    }

    public static void main(String[] args){
        BiConsumer<In1, In2> bic;
        bic = MethodConversion::accept;
        bic.accept(new In1(), new In2());
        bic = MethodConversion::someOtherName;
        bic.accept(new In1(),new In2());
    }
}
