package newio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/24 9:03
 */
public class BufferToText {
    private static final int BSIZE = 1024;
    private static final String FILE="newio/data2.txt";
    public static void main(String[] args){
        try(FileChannel fc = new FileOutputStream(FILE).getChannel()){
            fc.write(ByteBuffer.wrap("Some bytes".getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        try(FileChannel fc = new FileInputStream(FILE).getChannel()){
            fc.read(buff);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        buff.flip();
        //doesn't work
        System.out.println(buff.asCharBuffer());

        //decode using this system's default Charset:
        buff.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println("Decoded using "+encoding + ":"+ Charset.forName(encoding).decode(buff));

        //Encode with something that prints
        try(FileChannel fc = new FileOutputStream(FILE).getChannel()){
            fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //now try reading again;
        buff.clear();
        try(FileChannel fc = new FileInputStream(FILE).getChannel()){
            fc.read(buff);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        buff.flip();
        System.out.println(buff.asCharBuffer());


        //use a CharBuffer to write through
        buff = ByteBuffer.allocate(24);
        buff.asCharBuffer().put("Some text");
        try(FileChannel fc = new FileOutputStream(FILE).getChannel()){
            fc.write(buff);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //read and display
        buff.clear();
        try(FileChannel fc = new FileInputStream(FILE).getChannel()){
            fc.read(buff);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        buff.flip();
        System.out.println(buff.asCharBuffer());
    }
}
