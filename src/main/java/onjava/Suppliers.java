package onjava;

import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/10 19:25
 */
public class Suppliers {
    public static <T,C extends Collection<T>> C create(Supplier<C> factory, Supplier<T> gen ,int n){
        return Stream.generate(gen)
                .limit(n)
                .collect(factory, C::add, C::addAll);
    }

    public static <T,C extends  Collection<T>> C fill(C coll, Supplier<T> gen, int n){
         Stream.generate(gen)
                .limit(n)
                .forEach(coll::add);
        return coll;
    }
    public static <H, A> H fill(H holder, BiConsumer<H, A> adder, Supplier<A>gen, int n){
        Stream.generate(gen)
                .limit(n)
                .forEach(a->adder.accept(holder, a));
        return holder;
    }
}
