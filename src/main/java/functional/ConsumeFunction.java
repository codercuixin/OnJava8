package functional;

import java.util.function.Function;

class One{ }
class Two{}
/**
 * * @Author: cuixin
 * * @Date: 2020/5/29 19:09
 */
public class ConsumeFunction {
    static Two consume(Function<One, Two> oneTwoFunction){
        return oneTwoFunction.apply(new One());
    }
    public static  void main(String[] args){
        Two two = consume(one -> new Two());
    }
}
