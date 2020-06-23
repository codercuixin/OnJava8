package newio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/23 17:40
 */
public class GetChannel {
    private static String name = "newio/data.txt";
    private static final int BSIZE = 1024;

    public static void main(String[] args){
        try(FileChannel fc = new FileOutputStream(name).getChannel()){
            fc.write(ByteBuffer.wrap("Some text".getBytes()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(FileChannel fc = new RandomAccessFile(name, "rw").getChannel()){
            //move to the end;
            fc.position(fc.size());
            fc.write(ByteBuffer.wrap("Some more".getBytes()));
        } catch (IOException e) {
            throw new RuntimeException();
        }

        //read the file
        try(FileChannel fc = new FileInputStream(name).getChannel()){
            ByteBuffer buf = ByteBuffer.allocate(BSIZE);
            fc.read(buf);
            buf.flip();
            while(buf.hasRemaining()){
                System.out.write(buf.get());
            }
        } catch (IOException e) {
            throw new  RuntimeException(e);
        }
    }
}
