package streams;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/1 15:04
 */
public class OptionalBasics {
    static void test(Optional<String> optional){
        if(optional.isPresent()){
            System.out.println(optional.get());
        }else{
            System.out.println("Nothing inside");
        }
    }
    public static void main(String[] args){
        test(Stream.of("Epithets").findFirst());
        test(Stream.<String>empty().findFirst());
    }
}
