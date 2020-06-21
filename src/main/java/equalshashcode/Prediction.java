package equalshashcode;

import java.util.Random;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/11 16:51
 */
public class Prediction {
    private static Random rand = new Random(47);

    @Override
    public String toString() {
        return rand.nextBoolean()?
                "Six more weeks of Winter!":
                "Early Spring!";
    }
}
