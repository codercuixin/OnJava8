package newio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.RandomAccess;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/24 15:39
 */
public class LockingMappedFiles {
    //128MB
    static final int LENGTH = 0X8FFFFFF;
    static FileChannel fc;
    public static void main(String[] args) throws IOException {
        fc = new RandomAccessFile("test.dat",  "rw").getChannel();
        MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);
        for(int i=0; i<LENGTH; i++){
            out.put((byte)'x');
        }
        new LockAndModify(out, 0, 0+LENGTH/3);
        new LockAndModify(out, LENGTH/2, LENGTH/2+LENGTH/4);

    }

    private static class LockAndModify extends Thread{
        private ByteBuffer buff;
        private int start, end;
        LockAndModify(ByteBuffer mbb, int start, int end){
            this.start = start;
            this.end = end;
            mbb.limit(end);
            mbb.position(start);
            this.buff = mbb.slice();
            start();
        }

        @Override
        public void run() {
            try{
                //Exclusive lock with no overlap;
                FileLock f1 = fc.lock(start, end, false);
                System.out.println("Locked: "+start+" to "+end);
                //preform modification
                while(buff.position() < buff.limit() - 1){
                    buff.put((byte)(buff.get()+1));
                }
                f1.release();
                System.out.println("released: "+start+" to "+end);
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }
    }
}
