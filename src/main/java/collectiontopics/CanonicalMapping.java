package collectiontopics;

import java.util.Objects;
import java.util.WeakHashMap;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/12 19:57
 */
public class CanonicalMapping {
    public static void main(String[] args){
        int size = 1000;
        if(args.length > 0){
            size = Integer.valueOf(args[0]);
        }
        Key[] keys = new Key[size];
        WeakHashMap<Key, Value> map = new WeakHashMap<>();
        for(int i=0; i<size; i++){
            Key k = new Key(Integer.toString(i));
            Value v = new Value(Integer.toString(i));
            if(i%3==0){
                //save as "real" references
                keys[i] = k;
            }
            map.put(k, v);
        }
        System.gc();
    }
}
class Element{
    private String ident;
    Element(String id){
        this.ident = id;
    }

    @Override
    public String toString() {
        return ident;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ident);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Element
                && Objects.equals(ident, ((Element)obj).ident);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing "+ getClass().getSimpleName()+" "+ident);
    }
}
class Key extends Element{

    Key(String id) {
        super(id);
    }
}
class Value extends Element
{

    Value(String id) {
        super(id);
    }
}