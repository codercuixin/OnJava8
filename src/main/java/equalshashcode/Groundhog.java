package equalshashcode;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/11 16:50
 */
public class Groundhog {
    protected int number;
    public Groundhog(int number){
        this.number = number;
    }

    @Override
    public String toString() {
        return "Groundhog #"+number;
    }
}
