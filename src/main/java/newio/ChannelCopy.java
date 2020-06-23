package newio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/23 18:06
 */
public class ChannelCopy {
    private static  final int BSIZE = 1024;
    public static void main(String[] args){
        if(args.length != 2){
            System.out.println("arguments: sourcefile destfile");
            System.exit(1);
        }
        try(FileChannel in = new FileInputStream(args[0]).getChannel();
            FileChannel out = new FileOutputStream(args[1]).getChannel()
        ){
            ByteBuffer buf = ByteBuffer.allocate(BSIZE);
            while(in.read(buf)!=-1){
                buf.flip(); //prepare for writing
                out.write(buf);
                buf.clear();//prepare for reading
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

