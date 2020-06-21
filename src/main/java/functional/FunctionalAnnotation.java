package functional;

@FunctionalInterface
interface Functional {
    String goodbye(String arg);
}

interface FunctionalNoAnn {
    String goodbye(String arg);
}

//@FunctionalInterface
//interface NotFunctional{
//    String goodbye(String arg);
//    String hello(String arg);
//}

/**
 * * @Author: cuixin
 * * @Date: 2020/5/29 16:35
 */
public class FunctionalAnnotation {
    public String goodbye(String arg) {
        return "Goodbye, " + arg;
    }

    public static void main(String[] args) {
        FunctionalAnnotation fa = new FunctionalAnnotation();
        Functional f = fa::goodbye;
        Functional fna = fa::goodbye;
        //Incompatible
//        Functional fac = fa;
        Functional f1 = a -> "Goodbye, " + a;
        FunctionalNoAnn fnal = a -> "Goodbye, " + a;
        System.out.println(f.goodbye("Joey"));
        System.out.println(fna.goodbye("Joey"));
        System.out.println(f1.goodbye("Joey"));
        System.out.println(fnal.goodbye("Joey"));
    }
}
