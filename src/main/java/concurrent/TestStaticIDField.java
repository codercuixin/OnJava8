package concurrent;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/5 13:56
 */
public class TestStaticIDField {
    public static void main(String[] arg) {
        IDChecker.test(StaticIdField::new);
    }
}
