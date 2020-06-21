package equalshashcode;

import com.google.common.base.Objects;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/11 17:06
 */
public class Groundhog2 extends Groundhog {
    public Groundhog2(int number) {
        super(number);
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Groundhog2
                && Objects.equal(number, ((Groundhog2)obj).number);
    }
}
