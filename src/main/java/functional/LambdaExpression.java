package functional;

/**
 * * @Author: cuixin
 * * @Date: 2020/5/29 15:08
 */
interface Description{
String brief();
}
interface Body{
    String detailed(String head);
}
interface Multi{
    String twoArg(String head, Double d);
}

public class LambdaExpression {
    static Body bod = h -> h +"No parens";
    static Body bod2 = (h) -> h + "More details";
    static Description desc = ()-> "Short info";
    static Multi multi = (h, n) -> h+n;
    static Description moreLines = ()-> {
        System.out.println("moreLines()");
        return "from moreLines";
    };
    public static void main(String[] args){
        System.out.println(bod.detailed("Oh!"));
        System.out.println(bod2.detailed("Hi!"));
        System.out.println(desc.brief());
        System.out.println(multi.twoArg("Pi! ", 3.14159));
        System.out.println(moreLines.brief());
    }
}
