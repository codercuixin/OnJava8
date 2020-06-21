package collectiontopics;

import onjava.CountMap;

import java.util.Iterator;
import java.util.TreeMap;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/12 17:54
 */
public class SortedMapDemo {
    public static void main(String[] args){
        TreeMap<Integer, String> sortedMap = new TreeMap<>(new CountMap(10));
        System.out.println(sortedMap);
        Integer low = sortedMap.firstKey();
        Integer high = sortedMap.lastKey();
        System.out.println(low);
        System.out.println(high);
        Iterator<Integer> it = sortedMap.keySet().iterator();
        for(int i=0; i<=6; i++){
            if(i== 3){
                low =it.next();
            }else if(i==6){
                high = it.next();
            }else{
                it.next();
            }
        }
        System.out.println(low);
        System.out.println(high);
        System.out.println(sortedMap.subMap(low, high));
        System.out.println(sortedMap.headMap(high));
        System.out.println(sortedMap.tailMap(low));
    }
}
