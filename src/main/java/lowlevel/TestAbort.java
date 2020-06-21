package lowlevel;

import onjava.Nap;
import onjava.TimeAbort;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/8 16:59
 */
public class TestAbort {
    public static void main(String[] args){
        new TimeAbort(1);
        System.out.println("Napping for 4");
//        new Nap(4);
    }
}
