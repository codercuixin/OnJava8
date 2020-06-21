package collectiontopics;

import onjava.HTMLColors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/10 16:47
 */
public class SetOrder {
    static String[] sets={
            "java.util.HashSet",
            "java.util.TreeSet",
            "java.util.concurrent.ConcurrentSkipListSet",
            "java.util.LinkedHashSet",
            "java.util.concurrent.CopyOnWriteArraySet"
    };
    static final List<String> RLIST = new ArrayList<>(HTMLColors.LIST);
    static{
        Collections.reverse(RLIST);
    }
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        for(String type: sets){
            System.out.format("[ -> %s <- ]%n", type.substring(type.lastIndexOf('.')+1));
            @SuppressWarnings("unchecked")
            Set<String> set = (Set<String>) Class.forName(type).newInstance();
            set.addAll(RLIST);
            set.stream()
                    .limit(10)
                    .forEach(System.out::println);
        }
    }

}
