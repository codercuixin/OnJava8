package equalshashcode;

import onjava.Countries;

import java.util.*;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/11 17:31
 */
public class SimpleHashMap<K,V> extends AbstractMap<K, V> {

    //choose a prime number for the hash table size, to achive a uniform distribution
    static final int SIZE = 997;
    @SuppressWarnings("unchecked")
    LinkedList<MapEntry<K, V>> [] buckets = new LinkedList[SIZE];

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if(buckets[index] == null){
            buckets[index] = new LinkedList<>();
        }
        LinkedList<MapEntry<K,V>> bucket = buckets[index];
        MapEntry<K, V> pair = new MapEntry<>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();
        while (it.hasNext()){
            MapEntry<K,V> iPair = it.next();
            if(iPair.getKey().equals(key)){
                oldValue = iPair.getValue();
                it.set(pair);
                found = true;
                break;
            }
        }
        if(!found){
            buckets[index].add(pair);
        }
        return oldValue;
    }

    @Override
    public V get(Object key) {
        int index = Math.abs(key.hashCode()) %SIZE;
        if(buckets[index] == null){
            return  null;
        }
        for(MapEntry<K, V> iPair: buckets[index]){
            if(iPair.getKey().equals(key)){
                return iPair.getValue();
            }
        }
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
       Set<Map.Entry<K, V>> set = new HashSet<>();
       for(LinkedList<MapEntry<K,V>> bucket: buckets){
           if(bucket == null) continue;
           for(MapEntry<K, V> mapir: bucket){
               set.add(mapir);
           }
       }
       return set;
    }
    public static void main(String[] args){
        SimpleHashMap<String, String> m = new SimpleHashMap<>();
        m.putAll(Countries.capitals(8));
        m.forEach((k,v)->System.out.println(k+"="+v));
        System.out.println(m.get("BENIN"));
        m.entrySet().forEach(System.out::println);
    }
}
