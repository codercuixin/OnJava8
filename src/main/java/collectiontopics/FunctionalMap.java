package collectiontopics;
import java.util.Map;

import static onjava.HTMLColors.*;
/**
 * * @Author: cuixin
 * * @Date: 2020/6/10 17:12
 */
public class FunctionalMap {
    public static void main(String[] args){
        MAP.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(v-> v.startsWith("Dark"))
                .map(v->v.replaceFirst("Dark", "Hot"))
                .forEach(System.out::println);
    }
}
