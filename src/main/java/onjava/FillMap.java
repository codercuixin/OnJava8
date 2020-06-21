package onjava;

import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/12 11:30
 */
public class FillMap {
    public static <K,V> Map<K, V> basic(Supplier<Pair<K,V>> pairGen, int size){
        return Stream.generate(pairGen)
                .limit(size)
                .collect(Collectors.toMap(Pair::key, Pair::value));
    }

    public static <K,V> Map<K,V> basic(Supplier<K> kGen, Supplier<V> vGen, int size){
        return Stream.generate(()-> Pair.make(kGen.get(), vGen.get()))
                .limit(size)
                .collect(Collectors.toMap(Pair::key, Pair::value));
    }

    public static <K, V, M extends Map<K,V>> Map<K, V> create(Supplier<K> kGen, Supplier<V> vGen,
                                                              Supplier<M> mapSupplier, int size){
        return Stream.generate(()->Pair.make(kGen.get(), vGen.get()))
                .limit(size)
                .collect(Collectors.toMap(Pair::key, Pair::value, (k,v)->k, mapSupplier));
    }
}
