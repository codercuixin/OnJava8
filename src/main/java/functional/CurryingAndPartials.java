package functional;

import java.util.function.Function;

/**
 * * @Author: cuixin
 * * @Date: 2020/5/29 20:31
 */
public class CurryingAndPartials {
    static String uncurried(String a, String b){
        return a+b;
    }
    public static void main(String[] args){
        Function<String, Function<String, String>> sum =
                a-> b -> a+b;
        System.out.println(uncurried("Hi", "Ho"));
        Function<String, String> hi = sum.apply("Hi");
        System.out.println(hi.apply("Ho"));

        Function<String, String> sumHi = sum.apply("Hup ");
        System.out.println(sumHi.apply("HO"));
        System.out.println(sumHi.apply("hey"));
    }
}
