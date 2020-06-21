package streams;

import static streams.RandInts.rands;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/1 17:20
 */
public class SelectElement {
    public static void main(String[] args){
        System.out.println(rands().findFirst().getAsInt());
        System.out.println(rands().parallel().findFirst().getAsInt());
        System.out.println(rands().findAny().getAsInt());
        System.out.println(rands().parallel().findAny().getAsInt());
    }
}
