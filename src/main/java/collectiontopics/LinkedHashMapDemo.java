package collectiontopics;

import onjava.CountMap;

import java.util.LinkedHashMap;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/12 17:59
 */
public class LinkedHashMapDemo {
    public static void main(String[] args){
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>(new CountMap(9));
        System.out.println(linkedHashMap);
        //least-recently-used order
        linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.putAll(new CountMap(9));
        System.out.println(linkedHashMap);
        for(int i=0; i<6; i++){
            linkedHashMap.get(i);
        }
        System.out.println(linkedHashMap);
        linkedHashMap.get(0);
        System.out.println(linkedHashMap);
    }
}
