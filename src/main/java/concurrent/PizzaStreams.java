package concurrent;

import onjava.Timer;

import java.util.stream.IntStream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/5 14:48
 */
public class PizzaStreams {
    static final int QUANTITY = 17;
    public static void main(String[] args){
        Timer timer = new Timer();
        IntStream.range(0, QUANTITY)
                .mapToObj(Pizza::new)
                .parallel()
                .forEach(za->{
                    while (!za.complete()){
                        za.next();
                    }
                });
        System.out.println(timer.duration());
    }
}
//4->1677
//8->3367
//10->6399
//16->9372
//17->8150
