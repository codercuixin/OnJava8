package concurrent;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/4 14:19
 */
public class ParallelStreamPuzzle {
    static class IntGenerator implements Supplier<Integer>{
        private int current = 0;

        @Override
        public Integer get() {
            return current++;
        }
    }
    public static void main(String[] args){
        List<Integer> x = Stream.generate(new IntGenerator())
                .limit(10)
//                .parallel()
                .collect(Collectors.toList());
        System.out.println(x);
    }
}

//with parallel() differ each time
//[0, 11, 14, 15, 17, 19, 20, 21, 23, 25]
//[1, 4, 6, 8, 11, 13, 16, 18, 20, 22]

//without parallel()
