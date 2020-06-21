package lowlevel;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/8 18:18
 */
public class NotAtomic {
    int i;
    void f1(){
        i++;
    }
    void f2(){
        i+=3;
    }
}
