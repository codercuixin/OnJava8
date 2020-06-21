package functional;

import java.util.function.Function;

class I{
    @Override
    public String toString() {
        return "I";
    }
}
class O{
    @Override
    public String toString() {
        return "O";
    }
}
class H{
    @Override
    public String toString() {
        return "H";
    }
}
/**
 * * @Author: cuixin
 * * @Date: 2020/5/29 19:12
 */
public class TransformFunction {
    static Function<I, O> transform(Function<I, O> in){
        return in.andThen(o->{
            System.out.println(o);
            return o;
        });
    }
    // Function<I,O> andThen Function<O, H>, that is Function<I, H>
    static Function<I, H> transform2(Function<I, O> in){
        return in.andThen(o->{
            System.out.println(o);
            return new H();
        });
    }

    public static void main(String[] args){
//        Function<I, O> f2 = transform(i->{
//            System.out.println(i);
//            return new O();
//        });
//        O o = f2.apply(new I());

        Function<I, H> f2 = transform2(i->{
            System.out.println(i);
            return new O();
        });
        H h = f2.apply(new I());
        System.out.println(h);
    }
}
