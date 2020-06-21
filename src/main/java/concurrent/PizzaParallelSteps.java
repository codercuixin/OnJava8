package concurrent;

import onjava.Timer;

import java.util.stream.IntStream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/5 14:52
 */
public class PizzaParallelSteps {
    private static final int QUANTITY = 5;

    public static void main(String[] args) {
        Timer timer = new Timer();
        IntStream.range(0, QUANTITY)
                .mapToObj(Pizza::new)
                .parallel()
                .map(Pizza::roll)
                .map(Pizza::sauce)
                .map(Pizza::cheese)
                .map(Pizza::toppings)
                .map(Pizza::bake)
                .map(Pizza::slice)
                .map(Pizza::box)
                .forEach(System.out::println);
        System.out.println(timer.duration());
    }
}
