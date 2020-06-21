package functional;

/**
 * * @Author: cuixin
 * * @Date: 2020/5/29 17:47
 */
@FunctionalInterface
public interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}
