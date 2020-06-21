package functional;

class X {
    String f() {
        return "X::f()";
    }
    String g(String name){
        return "hello " +name;
    }
}

interface MakeString {
    String make();
}

interface TransformX{
    String transform(X x);
}
interface TransformX2{
    String trnasform(X x, String name);
}

/**
 * * @Author: cuixin
 * * @Date: 2020/5/29 15:49
 */
public class UnboundMethodReference {
    public static void main(String[] args){
//        MakeString ms = X::f;
//        TransformX sp = X::f;
//        X x = new X();
//        System.out.println(sp.transform(x));
//        System.out.println(x.f());
        TransformX2 transformX2 = X::g;
        X x = new X();
        System.out.println(transformX2.trnasform(x, "Joey"));
    }
}
