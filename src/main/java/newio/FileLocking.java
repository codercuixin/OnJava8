package newio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/24 15:27
 */
public class FileLocking {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("temp.tmp");
             FileLock fl = fos.getChannel().tryLock()
        ) {
            if (fl != null) {
                System.out.println("Locked File");
                TimeUnit.MILLISECONDS.sleep(100);
                fl.release();
                System.out.println("Release Lock");
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
