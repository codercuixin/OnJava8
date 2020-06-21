package functional;

import java.util.function.Function;
interface FuncSS extends Function<String, String>{}

/**
 * * @Author: cuixin
 * * @Date: 2020/5/29 19:04
 */
public class ProduceFunction {
    static FuncSS produce(){
        return s->s.toLowerCase();
    }
    public static void main(String[] args){
        FuncSS f = produce();
        System.out.println(f.apply("YELLING"));
    }
}
