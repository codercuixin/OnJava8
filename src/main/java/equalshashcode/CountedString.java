package equalshashcode;

import com.google.common.base.Objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/11 18:03
 */
public class CountedString {
    private static List<String> created = new ArrayList<>();
    private String s;
    private int id = 0;
    public CountedString(String str){
        this.s= str;
        created.add(s);
        for(String s2: created){
            if(s2.equals(s)){
                id++;
            }
        }
    }

    @Override
    public String toString() {
        return "String: "+s+" id: "+id+" hashCode():"+hashCode();
    }

    @Override
    public int hashCode() {
        //using Joshua bloch's recipe
        int result = 17;
        result = 37 * result + s.hashCode();
        result = 37 * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CountedString
                && Objects.equal(s, ((CountedString)obj).s)
                 && Objects.equal(id, ((CountedString)obj).id);

    }

    public static void main(String[] args){
        Map<CountedString, Integer> map = new HashMap<>();
        CountedString[] cs = new CountedString[5];
        for(int i=0; i<cs.length; i++){
            cs[i] = new CountedString("hi");
            map.put(cs[i], i);
        }
        System.out.println(map);
        for(CountedString countedString: cs){
            System.out.println("Looking up "+countedString);
            System.out.println(map.get(countedString));
        }
    }
}
