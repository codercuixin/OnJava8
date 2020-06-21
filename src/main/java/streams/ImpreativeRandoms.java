package streams;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/1 9:36
 */
public class ImpreativeRandoms {
    public static void main(String[] args){
        Random rand = new Random(47);
        SortedSet<Integer> rints = new TreeSet<>();
        while (rints.size() < 7){
            int r = rand.nextInt(20);
            if(r < 5){
                continue;
            }
            rints.add(r);
        }
        System.out.println(rints);

    }
}
