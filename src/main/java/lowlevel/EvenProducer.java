package lowlevel;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/8 17:02
 */
public class EvenProducer extends IntGenerator {
    private int currentEvenValue = 0;
    @Override
    public int next() {
        ++currentEvenValue;
        ++currentEvenValue;
        return currentEvenValue;
    }
    public static void main(String[] args){
        EvenChecker.test(new EvenProducer());
    }
}
