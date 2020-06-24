package newio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/24 10:27
 */
public class IntBufferDemo {
    private static final int BSIZE = 1024;
    public static void main(String[] args){
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        IntBuffer ib = bb.asIntBuffer();
        //store an array of int
        ib.put(new int[]{11, 42, 47, 99, 143, 811, 1016});
        //absolute location read and write;
        System.out.println(ib.get(3));
        ib.put(3, 1811);
        //setting a new limit before rewinding the buffer
        ib.flip();
        while(ib.hasRemaining()){
            int i = ib.get();
            System.out.println(i);
        }
    }
}
