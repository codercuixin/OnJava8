package equalshashcode;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/11 15:34
 */
public class DefaultComparison {
    private int i,j, k;
    DefaultComparison(int i, int j, int k){
        this.i = i;
        this.j = j;
        this.k = k;
    }
    public static void main(String[] args){
        DefaultComparison a = new DefaultComparison(1, 2, 3),
                b = new DefaultComparison(1, 2, 3);
        System.out.println(a==a);
        System.out.println(a==b);
        System.out.println(a.equals(b));
    }
}
