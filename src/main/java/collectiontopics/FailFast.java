package collectiontopics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/12 19:21
 */
public class FailFast {
    public static void main(String[] args){
        Collection<String> c = new ArrayList<>();
        Iterator<String> iterator = c.iterator();
        c.add("An object");
        try{
            String s = iterator.next();
            iterator.remove();
        }catch(ConcurrentModificationException e){
            System.out.println(e);
        }
    }
}
