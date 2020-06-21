package streams;

import java.util.stream.Stream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/1 11:11
 */
public class Fibonacci {
    int x = 1;
    Stream<Integer> numbers(){
        return Stream.iterate(0, i->{
            int result = x +i;
            x = i;
            return result;
        });
    }
    public static void main(String[] args){
        new Fibonacci().numbers().skip(20).limit(10).forEach(System.out::println);
    }
}
