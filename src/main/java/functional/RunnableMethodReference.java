package functional;
class Go{
    static void go(){
        System.out.println("Go::go");
    }
}
/**
 * * @Author: cuixin
 * * @Date: 2020/5/29 15:44
 */
public class RunnableMethodReference {
    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous");
            }
        }).start();
        new Thread(()->System.out.println("Lamda")).start();
        new Thread(Go::go).start();
    }
}
