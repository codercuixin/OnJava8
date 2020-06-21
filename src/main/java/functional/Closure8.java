package functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/**
 * * @Author: cuixin
 * * @Date: 2020/5/29 19:56
 */
public class Closure8 {
    Supplier<List<Integer>> makeFun(){
        final List<Integer> ai = new ArrayList<>();
        ai.add(1);
        return ()->ai;
    }
    public static void main(String[] args){
        Closure8 c8 = new Closure8();
        List<Integer> l1 = c8.makeFun().get();
        List<Integer> l2 = c8.makeFun().get();
        System.out.println(l1);
        System.out.println(l2);
        l1.add(42);
        l2.add(96);
        System.out.println(l1);
        System.out.println(l2);
    }
}
