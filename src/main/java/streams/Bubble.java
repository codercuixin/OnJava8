package streams;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/1 10:00
 */
public class Bubble {
    public final int i;
    public Bubble(int i){
        this.i = i;
    }

    @Override
    public String toString() {
        return "Bubble("+i+")";
    }
    private static int count = 0;
    public static Bubble bubbler(){
        return new Bubble(count++);
    }
}
