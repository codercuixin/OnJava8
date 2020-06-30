package references;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/29 15:42
 */
class Int{
    private int i;
    Int(int ii){
        i =ii;
    }
    public void increment(){
        i++;
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}
public class CloneArrayList {
    public static void main(String[] args){
        ArrayList<Int> v = IntStream.range(0, 10)
                .mapToObj(Int::new)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("v: "+v);
        @SuppressWarnings("unchecked")
                ArrayList<Int> v2= (ArrayList<Int>) v.clone();
        //Increment all v2's elements
        v2.forEach(Int::increment);
        System.out.println("v: "+v);

        Object object = new Object();

    }
}
