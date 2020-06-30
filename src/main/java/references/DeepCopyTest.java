package references;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/29 17:33
 */
public class DeepCopyTest {
    public static void main(String[] args){
        OceanReading reading = new OceanReading(33.9,100.5);
        OceanReading clone = reading.clone();
        TemperatureReading tr = clone.getTemperate();
        tr.setTemperature(tr.getTemperature()+1);
        clone.setTemperate(tr);

        DepthReading dr = clone.getDepth();
        dr.setDepth(dr.getDepth()+1);
        clone.setDepth(dr);

        assert reading.getTemperate().getTemperature() == 33.9;
        assert reading.getDepth().getDepth() == 100.5;
        assert clone.getTemperate().getTemperature() == 34.9;
        assert clone.getDepth().getDepth() == 101.5;
    }
}
