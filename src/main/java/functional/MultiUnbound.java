package functional;

class This{
    void two(int i, double d){}
    void three(int i, double d, String s){}
    void four(int i, double d, String s, char c){}
}
interface TwoArgs{
    void call2(This athis, int i, double d);
}
interface ThreeArgs{
    void call3(This athis, int i, double d, String s);
}
interface FourArgs{
    void call4(This athis, int i, double d, String s, char c);
}
/**
 * * @Author: cuixin
 * * @Date: 2020/5/29 16:01
 */
public class MultiUnbound {
    public static void main(String[] args){
        TwoArgs twoArgs = This::two;
        ThreeArgs threeArgs = This::three;
        FourArgs fourArgs = This::four;
        This athis = new This();
        twoArgs.call2(athis, 1, 2.0);
        threeArgs.call3(athis, 1, 2.0, "3.0");
        fourArgs.call4(athis, 1, 2.0, "3.0", '4');
    }
}
