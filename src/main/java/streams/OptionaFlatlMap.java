package streams;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/1 15:51
 */
public class OptionaFlatlMap {
    static String[] elements = {"12", "", "23", "45"};
    static Stream<String> testStream(){
        return Arrays.stream(elements);
    }
    static void test(String desc, Function<String, Optional<String>> func){
        System.out.println("- - - ( " +desc+" ) - - -");
        for(int i=0; i<=elements.length; i++){
            System.out.println(testStream().skip(i).findFirst().flatMap(func));
        }
    }
    public static void main(String[] args){
        test("Add brackets", s-> Optional.of("["+s+"]"));
        test("Increment", s->{
            try{
                return Optional.of(Integer.parseInt(s)+1+"");
            }catch (NumberFormatException e){
                return Optional.of(s);
            }
        });
        test("Replace", s-> Optional.of(s.replace("2", "9")));
        test("Take last digit", s->Optional.of(s.length() > 0 ? s.charAt(s.length() - 1)+"": s));
    }
}
