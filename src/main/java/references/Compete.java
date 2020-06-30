package references;

import onjava.Timer;

import java.io.*;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/29 18:10
 */
class Thing1 implements Serializable {

}

class Thing2 implements Serializable {
    Thing1 thing1 = new Thing1();
}

class Thing3 implements Cloneable {
    @Override
    public Thing3 clone() {
        try {
            return (Thing3) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

//1.实现Cloneable接口，否则会抛出CloneNotSupportedException
class Thing4 implements Cloneable {
    private Thing3 t3 = new Thing3();

    //2.重写clone方法，更改为public
    @Override
    public Thing4 clone() {
        try {
            //3.调用super.clone, 从旧对象按位复制到新对象
            Thing4 thing4 = (Thing4) super.clone();
            //4.clone reference field too
            thing4.t3 = thing4.t3.clone();
            return thing4;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class Compete {
    public static final int SIZE = 100000;

    public static void main(String[] args) throws Exception {
        Thing2[] a = new Thing2[SIZE];
        for (int i = 0; i < SIZE; i++) {
            a[i] = new Thing2();
        }
        Thing4[] b = new Thing4[SIZE];
        for (int i = 0; i < SIZE; i++) {
            b[i] = new Thing4();
        }
        Timer timer = new Timer();
        try (
                ByteArrayOutputStream buf = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(buf)
        ) {
            for (Thing2 a1 : a) {
                oos.writeObject(a1);
            }
            //now get copies
            try (ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()))) {
                Thing2[] c = new Thing2[SIZE];
                for (int i = 0; i < SIZE; i++) {
                    c[i] = (Thing2) in.readObject();
                }
            }
        }
        System.out.println("Duplication via serialization: "+timer.duration()+" milliseconds");

        //now try cloning;
        timer = new Timer();
        Thing4[] d = new Thing4[SIZE];
        for(int i=0; i<SIZE; i++){
            d[i] = b[i].clone();
        }
        System.out.println("Duplication via cloning: "+timer.duration()+" milliseconds");
        //result: clone快至少一个数量级
    }
}
