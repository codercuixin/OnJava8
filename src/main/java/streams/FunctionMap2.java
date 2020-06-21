package streams;

import java.util.stream.Stream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/1 14:23
 */
class Numbered{
    final int n;
    Numbered(int n){
        this.n = n;
    }

    @Override
    public String toString() {
        return "Numbered("+this.n+")";
    }
}
public class FunctionMap2 {
    public static void main(String[] args){
        Stream.of(1, 5, 7, 9, 11, 13)
                .map(Numbered::new)
                .forEach(System.out::println);
    }
}
