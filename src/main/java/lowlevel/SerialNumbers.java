package lowlevel;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/8 19:07
 */
public class SerialNumbers {
    private volatile int serialNumber = 0;
    public int nextSerialNumber(){
        //not thread-safe
        return serialNumber++;
    }
}
