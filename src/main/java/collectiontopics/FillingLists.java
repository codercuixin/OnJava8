package collectiontopics;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/10 19:17
 */
public class FillingLists {
    public static void main(String[] args){
//        StringAddress s1 = new StringAddress("Hello");
//        List<StringAddress> list = new ArrayList<>(Collections.nCopies(4, s1));
//        System.out.println(list);
//        s1.setS("Hello2");
//        System.out.println(list);
//
//        Collections.fill(list, new StringAddress("World!"));
//        System.out.println(list);
//        IntStream.range(0, 10)
//                .filter(i-> i %2 == 0)
//                .peek(i-> System.out.println("peeking "+i))
//                .forEach(System.out::println);

//        List<String> l = new ArrayList(Arrays.asList("one", "two"));
//        Stream<String> sl = l.stream();
//        l.add("three");
//        String s = sl.collect(joining(" "));

        Set<Integer> seen = Collections.synchronizedSet(new HashSet<>());
        seen.stream().parallel().map(e -> { if (seen.add(e)) return 0; else return e; });
        System.out.println(seen);
    }
}
 class StringAddress {
    private String s;
    StringAddress(String s){
        this.s = s;
    }

     public void setS(String s) {
         this.s = s;
     }

     @Override
    public String toString() {
        return super.toString() +" "+s;
    }
}

