package serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * * @Author: cuixin
 * * @Date: 2020/7/1 9:30
 */
public class RecoverCADState {
    public static void main(String[] args){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("CADState.dat"))){
            List<Class<? extends Shape>>
                    shapeTypes = (List<Class<? extends Shape>>) in.readObject();
            Line.deserializeStaticState(in);
            List<Shape> shapes = (List<Shape>) in.readObject();
            System.out.println(shapes);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
