package serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/30 17:54
 */
public class FreezeAlien {
    public static void main(String[] args) throws IOException {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("X.file"))){
            Alien quellek = new Alien();
            out.writeObject(quellek);
        }
    }
}
