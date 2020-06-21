package functional;

import java.util.Comparator;
import java.util.function.*;

class AA{}
class BB{}
class CC{}
/**
 * * @Author: cuixin
 * * @Date: 2020/5/29 17:25
 */
public class ClassFunctionals {
    static AA f1(){
        return new AA();
    }
    static int f2(AA aa1, AA aa2){
        return 1;
    }
    static void f3(AA aa){}
    static void f4(AA aa, BB bb){}
    static CC f5(AA aa){return new CC();}
    static CC f6(AA aa, BB bb){return new CC();}
    static boolean f7(AA aa){ return true;}
    static boolean f8(AA aa, BB bb){return true;}
    static AA f9(AA aa){
        return new AA();
    }
    static AA f10(AA aa1, AA aa2){return new AA();}
    public static void main(String[] args){
        Supplier<AA> s = ClassFunctionals::f1;
        AA sRes = s.get();
        Comparator<AA> c = ClassFunctionals::f2;
        int cRes = c.compare(new AA(), new AA());
        Consumer<AA> cons = ClassFunctionals::f3;
        cons.accept(new AA());
        BiConsumer<AA, BB> biCons = ClassFunctionals::f4;
        biCons.accept(new AA(), new BB());
        Function<AA,CC> func = ClassFunctionals::f5;
        CC cc = func.apply(new AA());
        BiFunction<AA, BB, CC> biFunc = ClassFunctionals::f6;
        cc = biFunc.apply(new AA(), new BB());
        Predicate<AA> predicate1 = ClassFunctionals::f7;
        boolean pre = predicate1.test(new AA());
        BiPredicate<AA, BB> biPredicate = ClassFunctionals::f8;
        boolean biPre = biPredicate.test(new AA(), new BB());
        UnaryOperator<AA> op1 = ClassFunctionals::f9;
        AA op1Res = op1.apply(new AA());
        BinaryOperator<AA> op2 = ClassFunctionals::f10;
        AA op2Res = op2.apply(new AA(), new AA());
    }
}
