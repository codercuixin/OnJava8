package serialization;

import java.io.*;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/30 18:12
 */
public class Blip3 implements Externalizable {
    private int i;
    private String s;
    public Blip3(){
        System.out.println("Blip3 Constructor");
    }
    public Blip3(String x, int a){
        System.out.println("Blip3(String x, int a)");
        s = x;
        i = a;
    }

    @Override
    public String toString() {
        return s+i;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip3.writeExternal");
        //you must do this
        out.writeObject(s);
        out.writeInt(i);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip3.readExternal");
        //you must do this
//        s = (String) in.readObject();
//        i = in.readInt();
    }

    public static void main(String[] args){
        System.out.println("Constructor objects: ");
        Blip3 b3 = new Blip3("A string", 47);
        System.out.println(b3);
        try(ObjectOutputStream o =  new ObjectOutputStream(new FileOutputStream("Blip3.serialized"))){
            System.out.println("Saving object: ");
            o.writeObject(b3);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //now get it back;
        System.out.println("Recovering b3: ");
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blip3.serialized"))){
            b3 = (Blip3) in.readObject();
            System.out.println(b3);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
