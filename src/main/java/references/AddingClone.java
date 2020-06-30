package references;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/29 17:51
 */
class Int2 implements Cloneable{
    private int i;
    Int2(int ii){
        i =ii;
    }
    public void increment(){
        i++;
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }

    @Override
    public Int2 clone(){
        try{
            return (Int2) super.clone();
        }catch (CloneNotSupportedException e){
            throw new RuntimeException(e);
        }
    }

    public int getI() {
        return i;
    }
}
//Inheritance doesn't remove cloneablitiy;
class Int3 extends Int2{
    private int j;
    Int3(int i){
        super(i);
    }
    Int3(int i, int j){
        super(i);
        this.j = j;
    }

    public int getJ() {
        return j;
    }
}
public class AddingClone {
    public static void main(String[] args){
        Int2 x = new Int2(10);
        Int2 x2 = x.clone();
        x2.increment();
        System.out.println("x = "+x +", x2 = "+x2);

        //Anything inherited is also cloneable
        Int3 x3 = new Int3(7, 10);
        Int3 x3Clone = (Int3) x3.clone();
        System.out.printf("x3 clone: i= %d, j=%d\n", x3Clone.getI(), x3.getJ());

        ArrayList<Int2> v = IntStream.range(0, 10)
                .mapToObj(Int2::new)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("v: "+v);
        ArrayList<Int2> v2 = (ArrayList<Int2>) v.clone();
        //now clone each element
        IntStream.range(0, v.size())
                .forEach(i->v2.set(i, v.get(i)).clone());
        //Increment all v2's element
        v2.forEach(Int2::increment);
        System.out.println("v2: "+v2);
        //see if it changed v's element
        System.out.println("v: "+v);
    }
}
