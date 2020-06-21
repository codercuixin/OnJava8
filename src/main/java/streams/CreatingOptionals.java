package streams;

import java.util.Optional;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/1 15:33
 */
public class CreatingOptionals {
    static void test(String testName, Optional<String> opt){
        System.out.println(" === "+testName +" ===");
        System.out.println(opt.orElse("NULL"));
    }
    public static void main(String[] ars){
        test("empty", Optional.empty());
        test("of", Optional.of("Howdy"));
        try{
            test("of", Optional.of(null));
        }catch (Exception e){
            System.out.println(e);
        }
        test("ofNullable", Optional.ofNullable("Hi"));
        test("ofNullable", Optional.ofNullable(null));
    }
}
