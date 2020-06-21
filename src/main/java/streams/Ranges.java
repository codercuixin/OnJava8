package streams;

import static java.util.stream.IntStream.range;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/1 10:52
 */
public class Ranges {
    public static void main(String[] args){
        int result = 0;
        for(int i=10; i<20; i++){
            result += i;
        }
        System.out.println(result);

        //for-in with a range
        result = 0;
        for(int i: range(10, 20).toArray()){
            result+=i;
        }
        System.out.println(range(10, 20).sum());
    }
}
