package newio;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/24 9:43
 */
public class AvailableCharSets {
    public static void main(String[] args){
        SortedMap<String, Charset> charsets = Charset.availableCharsets();
        for(String csName: charsets.keySet()){
            System.out.print(csName);
            Iterator aliases = charsets.get(csName).aliases().iterator();
            if(aliases.hasNext()){
                System.out.print(": ");
            }
            while(aliases.hasNext()){
                System.out.print(aliases.next());
                if(aliases.hasNext()){
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}
