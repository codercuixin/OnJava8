package concurrent;

import onjava.Timer;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/5 14:57
 */
public class CompletablePizza {
    static final int QUANTITY = 5;
    public static CompletableFuture<Pizza> makeCF(Pizza za){
        return CompletableFuture.completedFuture(za)
                .thenApplyAsync(Pizza::roll)
                .thenApplyAsync(Pizza::sauce)
                .thenApplyAsync(Pizza::cheese)
                .thenApplyAsync(Pizza::toppings)
                .thenApplyAsync(Pizza::bake)
                .thenApplyAsync(Pizza::slice)
                .thenApplyAsync(Pizza::box);
    }
    public static void show(CompletableFuture<Pizza> cf){
        try{
            System.out.println(cf.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args){
        Timer timer = new Timer();
        List<CompletableFuture<Pizza>> pizzas = IntStream.range(0, QUANTITY)
                .mapToObj(Pizza::new)
                .map(CompletablePizza::makeCF)
                .collect(Collectors.toList());
        System.out.println(timer.duration());
        pizzas.forEach(CompletablePizza::show);
        System.out.println(timer.duration());
    }
}
