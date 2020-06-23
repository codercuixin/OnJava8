package newio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/23 18:13
 */
public class TransferTo {
    public static void main(String[] args){
        if(args.length != 2){
            System.out.println("arguments: sourcefile destfile");
            System.exit(1);
        }

        try(FileChannel in = new FileInputStream(args[0]).getChannel();
            FileChannel out = new FileOutputStream(args[1]).getChannel()
        ){

            in.transferTo(0, in.size(), out);
//            out.transferFrom(in,0, in.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
