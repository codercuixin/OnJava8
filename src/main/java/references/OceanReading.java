package references;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/29 17:28
 */
public class OceanReading implements Cloneable{
    private DepthReading depth;
    private TemperatureReading temperate;
    OceanReading(double tdata, double ddata){
        temperate = new TemperatureReading(tdata);
        depth = new DepthReading(ddata);
    }

    @Override
    public OceanReading clone(){
        OceanReading or = null;
        try{
            or = (OceanReading) super.clone();
        }catch (CloneNotSupportedException e){
            throw new RuntimeException(e);
        }
        or.depth = or.depth.clone();
        or.temperate = or.temperate.clone();
        return or;
    }

    public DepthReading getDepth() {
        return depth;
    }

    public void setDepth(DepthReading depth) {
        this.depth = depth;
    }

    public TemperatureReading getTemperate() {
        return temperate;
    }

    public void setTemperate(TemperatureReading temperate) {
        this.temperate = temperate;
    }

    @Override
    public String toString() {
        return "OceanReading{" +
                "depth=" + depth +
                ", temperate=" + temperate +
                '}';
    }
}
