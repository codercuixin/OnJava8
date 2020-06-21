package onjava;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/12 13:40
 */
public class CountMap extends AbstractMap<Integer, String> {
    private int size;
    private static char[] chars =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static String value(int key){
        return chars[key% chars.length]
                +Integer.toString(key/chars.length);
    }
    public CountMap(int size){
        this.size = size <0?0:size;
    }

    @Override
    public String get(Object key) {
        return value((Integer)key);
    }
    private static class Entry implements Map.Entry<Integer, String>{
        int index;
        Entry(int index){
            this.index = index;
        }
        @Override
        public Integer getKey() {
            return index;
        }

        @Override
        public String getValue() {
            return value(index);
        }

        @Override
        public String setValue(String value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Entry
                    && Objects.equals(this.index, ((Entry)obj).index);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(index);
        }
    }

    @Override
    public Set<Map.Entry<Integer, String>> entrySet() {
        return IntStream.range(0, size)
                .mapToObj(Entry::new)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public static void main(String[] args){
        final int size = 6;
        CountMap cm = new CountMap(60);
        System.out.println(cm);
        System.out.println(cm.get(500));
        cm.values().stream().limit(size)
                .forEach(System.out::println);
        System.out.println();
        new Random(47).ints(size, 0, 1000)
                .mapToObj(cm::get)
                .forEach(System.out::println);
    }
}
