package serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/30 19:56
 */
class House implements Serializable{ }
class Animal implements Serializable{
    private String name;
    private House preferredHouse;
    Animal(String name, House h){
        this.name = name;
        this.preferredHouse = h;
    }

    @Override
    public String toString() {
        return name+"["+super.toString()+"], "
                +preferredHouse+"\n";
    }
}
public class MyWorld {
    public static void main(String[] args){
        House house = new House();
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Bosco the dog", house));
        animals.add(new Animal("Ralph the haamster", house));
        animals.add(new Animal("Molly the cat", house));
        System.out.println("animals: "+animals);
        try(ByteArrayOutputStream buf1 = new ByteArrayOutputStream();
            ObjectOutputStream o1 = new ObjectOutputStream(buf1)
        ){
            o1.writeObject(animals);
            o1.writeObject(animals);
            //write to a different stream:
            try(ByteArrayOutputStream buf2 = new ByteArrayOutputStream();
                ObjectOutputStream o2 = new ObjectOutputStream(buf2)
            ){
                o2.writeObject(animals);
                //now get them back
                try(ObjectInputStream in1 = new ObjectInputStream(
                        new ByteArrayInputStream(buf1.toByteArray()));
                    ObjectInputStream in2 = new ObjectInputStream(
                            new ByteArrayInputStream(buf2.toByteArray())
                    )
                ){
                    List animals1 = (List)in1.readObject(),
                            animals2 = (List) in1.readObject(),
                            animals3 = (List)in2.readObject();
                    System.out.println("animal1: "+animals1);
                    System.out.println("animal2: "+animals2);
                    System.out.println("animal3: "+animals3);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
