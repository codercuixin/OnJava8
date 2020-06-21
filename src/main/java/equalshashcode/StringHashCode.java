package equalshashcode;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/11 17:58
 */
public class StringHashCode {
    public static void main(String[] args){
        String[] hellos = "Hello Hello".split(" ");
        System.out.println(hellos[0].hashCode());
        System.out.println(hellos[1].hashCode());
    }
}
