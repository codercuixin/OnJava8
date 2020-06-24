package newio;

import java.io.*;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/24 13:54
 */
public class MappedIO {
    private static int numOfInts = 4000000;
    private static  int numOfUbuffInts = 100000;
    private abstract static class Tester{
        private String name;
        Tester(String name){
            this.name = name;
        }
        public void runTest(){
            System.out.print(name+": ");
            long start = System.nanoTime();
            test();
            double duration = System.nanoTime() - start;
            System.out.format("%.2f%n", duration/1.0e9);
        }
        public abstract void test();
    }

    private static Tester[] tests = {
            new Tester("Stream write") {
                @Override
                public void test() {
                    try(DataOutputStream dos = new
                            DataOutputStream(new BufferedOutputStream(
                                    new FileOutputStream(new File("temp.tmp")))))
                    {
                        for(int i=0; i<numOfInts; i++){
                            dos.writeInt(i);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            },
            new Tester("Mapped write") {
                @Override
                public void test() {
                    try(FileChannel fc = new RandomAccessFile("temp.tmp", "rw").getChannel()){
                        IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
                        for(int i=0; i<numOfInts; i++){
                            ib.put(i);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            },
            new Tester("Stream Read") {
                @Override
                public void test() {
                    try(DataInputStream dis = new
                            DataInputStream(new BufferedInputStream(
                            new FileInputStream(new File("temp.tmp")))))
                    {
                        for(int i=0; i<numOfInts; i++){
                            dis.readInt();
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            },
            new Tester("Mapped read") {
                @Override
                public void test() {
                    try(FileChannel fc = new RandomAccessFile("temp.tmp", "rw").getChannel()){
                        IntBuffer ib = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size()).asIntBuffer();
                        while(ib.hasRemaining()){
                            ib.get();
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            },
            new Tester("Stream read/write") {
                @Override
                public void test() {
                    try(RandomAccessFile raf = new RandomAccessFile("temp.tmp", "rw")){
                        raf.writeInt(1);
                        for(int i=0; i<numOfUbuffInts; i++){
                            raf.seek(raf.length() - 4);
                            raf.writeInt(raf.readInt());
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            },
            new Tester("Mapped read/write") {
                @Override
                public void test() {
                    try(FileChannel fc = new RandomAccessFile("temp.tmp", "rw").getChannel()){
                        IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
                         ib.put(0);
                         for(int i=1; i<numOfUbuffInts; i++){
                             ib.put(ib.get(i-1));
                         }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            },
    };

    public static void main(String[]args){
        Arrays.stream(tests).forEach(Tester::runTest);
    }

}
