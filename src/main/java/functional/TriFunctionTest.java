package functional;

/**
 * * @Author: cuixin
 * * @Date: 2020/5/29 17:48
 */
public class TriFunctionTest {
    static int f(int i, long l, double d){
        return (int)(i+l+d);
    }
    public static void main(String[] args){
        //方法引用赋值给功能性接口 method reference assigned to functional interfaces
        TriFunction<Integer,Long,Double, Integer> triFunction = TriFunctionTest::f;
        int res = triFunction.apply(1,2L, 3.0);
        System.out.println(res);

        //Lambda表达式赋值给功能性接口
        triFunction = (i, l, d) -> (int)(i+1+d);

    }
}
