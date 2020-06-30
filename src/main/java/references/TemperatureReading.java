package references;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/29 17:14
 */
public class TemperatureReading implements Cloneable {
    private long time;
    private double temperature;
    public TemperatureReading(double temperature){
        this.time = System.currentTimeMillis();
        this.temperature = temperature;
    }
    @Override
    public TemperatureReading clone(){
        try{
            return (TemperatureReading) super.clone();
        }catch (CloneNotSupportedException e){
            throw new RuntimeException(e);
        }
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
