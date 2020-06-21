package concurrent;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/5 13:19
 */
public class StaticIdField implements HasID {
    private static int counter = 0;
    private int id = counter++;
    @Override
    public int getID() {
        return id;
    }
}
