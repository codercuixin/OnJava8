package lowlevel;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/8 19:29
 */
public class AtomicSerialNumbers extends SerialNumbers{
    private AtomicInteger serialNumber = new AtomicInteger();

    @Override
    public int nextSerialNumber() {
        return serialNumber.getAndIncrement();
    }
    public static void main(String[] args){
        SerialNumberChecker.test(new AtomicSerialNumbers());
    }
}
