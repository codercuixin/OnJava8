package references;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/29 15:35
 */
public class Alias2 {
    private int i;
    public Alias2(int i){
        this.i = i;
    }
    public static void f(Alias2 reference){
        reference.i++;
    }
    public static void main(String[] args){
        Alias2 x = new Alias2(7);
        System.out.println("x: "+x.i);
        System.out.println("Calling f(x) ");
        f(x);
        System.out.println("x: "+x.i);
        Integer i;
    }
}
