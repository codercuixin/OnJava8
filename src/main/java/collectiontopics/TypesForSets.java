package collectiontopics;

import com.google.common.base.Objects;

import java.util.*;
import java.util.function.Function;

/**
 * set集合中都需要实现equals,因为不允许出现相等（equals返回true）的元素
 */
class SetType{
    protected int i;
    SetType(int n){
        this.i = n;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof SetType
                && Objects.equal(this.i, ((SetType)obj).i);
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}

/**
 * hashset集合的元素，除了equals，还需要实现hashCode来找对应的桶bucket(slot)
 */
class  HashType extends SetType{

    HashType(int n) {
        super(n);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.i);
    }
}

/**
 * TreeSet集合的元素，除了equals，还需要Comparable接口，为了在树中排序
 */

class TreeType extends SetType implements Comparable<TreeType>{

    TreeType(int n) {
        super(n);
    }

    @Override
    public int compareTo(TreeType o) {
        return Integer.compare(o.i, this.i);
    }
}


/**
 * * @Author: cuixin
 * * @Date: 2020/6/12 14:52
 */
public class TypesForSets {

    static <T> void fill(Set<T> set, Function<Integer, T> type){
        for(int i=10; i>=5; i--){
            //descending
            set.add(type.apply(i));
        }
        for(int i=0; i<5; i++){
            //ascendign
            set.add(type.apply(i));
        }
    }

    static <T> void test(Set<T> set, Function<Integer, T> type){
        fill(set, type);
        fill(set, type);
        fill(set, type);
        System.out.println(set);
    }

    public static void main(String[] args){
        test(new HashSet<>(), HashType::new);
        test(new LinkedHashSet<>(), HashType::new);
        test(new TreeSet<>(), TreeType::new);

        //things that don't work
        test(new HashSet<>(), SetType::new);
        test(new HashSet<>(), TreeType::new);
        test(new LinkedHashSet<>(), SetType::new);
        test(new LinkedHashSet<>(), TreeType::new);
        try{
            test(new TreeSet<>(), SetType::new);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            test(new TreeSet<>(), HashType::new);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
