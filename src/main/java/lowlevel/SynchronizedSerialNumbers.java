package lowlevel;


/**
 * * @Author: cuixin
 * * @Date: 2020/6/8 19:22
 */
public class SynchronizedSerialNumbers extends SerialNumbers {
    private int serialNumber = 0;
    @Override
    public synchronized int nextSerialNumber(){
        return serialNumber++;
    }
    public static void main(String[] args){
        SerialNumberChecker.test(new SynchronizedSerialNumbers());
    }
}
