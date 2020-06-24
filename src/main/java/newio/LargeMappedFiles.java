package newio;

import org.w3c.dom.ranges.RangeException;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/24 13:37
 */
public class LargeMappedFiles {
    // 128 MB
    static int length = 0x8000000;
    public static void main(String[] args){
        try(RandomAccessFile tdat = new RandomAccessFile("newio/test.dat", "rw")){
            MappedByteBuffer out = tdat.getChannel().map(FileChannel.MapMode.READ_WRITE, 0 , length);
            for(int i=0; i<length; i++){
                out.put((byte)'x');
            }
            System.out.println("Finishing writing");
            for(int i=length/2; i<length/2+6; i++){
                System.out.print((char)out.get(i));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
