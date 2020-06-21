package collectiontopics;

import java.util.*;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/12 14:24
 */
public class Unsupported {
    static void check(String description, Runnable test){
        try{
            test.run();
        }catch (Exception e){
            System.out.println(description+"(): "+e);
        }
    }
    static void test(String msg, List<String> list){
        System.out.println("- - - "+msg+" - - -");;
        Collection<String> c = list;
        Collection<String> subList = list.subList(1, 8);
        //copy of the sublist
        Collection<String> c2 = new ArrayList<>(subList);
        check("retainALl", ()->c.retainAll(c2));
        check("removeAll", ()->c.retainAll(c2));
        check("clear", ()->c.clear());
        check("add", ()->c.add("X"));
        check("addAll", ()->c.addAll(c2));
        check("remove", ()->c.remove("C"));

        check("List.set", ()->list.set(0, "X"));
    }

    public static void main(String[] args){
        List<String> list = Arrays.asList("A B C D E F G H I J K L".split(" "));
        test("Modifiable Copy", new ArrayList<>(list));
        test("Arrays.asList", list);
        test("unmodifiableList()", Collections.unmodifiableList(new ArrayList<>(list)));
    }


}
