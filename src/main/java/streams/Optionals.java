package streams;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/1 15:07
 */
public class Optionals {
    static void basics(Optional<String> optional){
        if(optional.isPresent()){
            System.out.println(optional.get());
        }else{
            System.out.println("Nothing inside");
        }
    }
    static void ifPresent(Optional<String> optionalS){
        optionalS.ifPresent(System.out::println);
    }
    static void orElse(Optional<String> optionalS){
        System.out.println(optionalS.orElse("Nada"));
    }
    static void orElseGet(Optional<String> optional){
        System.out.println(optional.orElseGet(()-> "Generated"));
    }
    static void orElseThrow(Optional<String> optionalS)  {
        try {
            System.out.println(optionalS.orElseThrow(()->new Exception("Supplied")));
        } catch (Exception e) {
            System.out.println("Caught "+e);
        }
    }

    static void test(String testName, Consumer<Optional<String>> cos){
        System.out.println(" ==== " + testName + " === ");
        cos.accept(Stream.of("Epithets").findFirst());
        cos.accept(Stream.<String>empty().findFirst());
    }

    public static void main(String[] args){
        test("basics", Optionals::basics);
        test("ifPresent", Optionals::ifPresent);
        test("orElse", Optionals::orElse);
        test("orElseGet", Optionals::orElseGet);
        test("orElseThrow", Optionals::orElseThrow);
    }
}
