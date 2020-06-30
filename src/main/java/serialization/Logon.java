package serialization;

import onjava.Nap;

import java.io.*;
import java.util.Date;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/30 19:25
 */
public class Logon implements Serializable {
    private Date date = new Date();
    private String userName;
    private transient String password;

    public Logon(String name, String pwd){
        userName = name;
        password = pwd;
    }

    @Override
    public String toString() {
        return "Logon{" +
                "date=" + date +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public static void main(String[] args){
        Logon a = new Logon("Hulk", "MyLittlePony");
        System.out.println("Logon a = "+a);
        try(ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Logon.dat"))){
            o.writeObject(a);
        }catch (IOException e){
            throw new RuntimeException(e);
        }

        new Nap(1);
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("Logon.dat"))){
            System.out.println("Recovering object at "+new Date());
            a = (Logon)in.readObject();
            System.out.println("Logon a = "+a);
        }catch (IOException | ClassNotFoundException e){
            throw  new RuntimeException(e);
        }
    }
}
