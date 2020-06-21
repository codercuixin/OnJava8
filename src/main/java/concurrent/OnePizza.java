package concurrent;

import onjava.Timer;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/5 14:46
 */
public class OnePizza {
    public static void main(String[] args){
        Pizza za = new Pizza(0);
        System.out.println(Timer.duration(()->{
            while (!za.complete()){
                za.next();
            }
        }));
    }
}
