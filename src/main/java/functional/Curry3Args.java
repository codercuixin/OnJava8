package functional;

import java.util.function.Function;

/**
 * * @Author: cuixin
 * * @Date: 2020/5/29 20:37
 */
public class Curry3Args {
    public static void main(String[] args){
        Function<String, Function<String, Function<String, String>>>
                sum = a->b->c-> a+b+c;
        Function<String, Function<String, String>> hi = sum.apply("Hi ");
        Function<String, String> ho = hi.apply("ho ");
        System.out.println(ho.apply("hup"));
    }
}
