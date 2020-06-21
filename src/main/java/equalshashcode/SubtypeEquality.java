package equalshashcode;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * -1622780347
 * * @Author: cuixin
 * * @Date: 2020/6/11 16:22
 */
public class SubtypeEquality {
    public static void main(String[] args){
        Set<Animal> pets = new HashSet<>();
        pets.add(new Dog("Ralph", Size.MEDIUM));
        pets.add(new Pig("Ralph", Size.MEDIUM));
        pets.forEach(System.out::println);
    }
}
enum Size{
    SAMLL, MEDIUM, LARGE
}
class Animal{
    private static int counter = 0;
    private final int id = counter++;
    private final String name;
    private final Size size;
    Animal(String name, Size size){
        this.name = name;
        this.size = size;
    }

    @Override
    public boolean equals(Object rval) {
        return rval instanceof Animal
//                && Objects.equals(this.id, ((Animal)rval).id)
                && Objects.equals(this.name, ((Animal)rval).name)
                && Objects.equals(this.size ,((Animal)rval).size);
    }
    @Override
    public int hashCode(){
//        return Objects.hash(name, size, id);
        return Objects.hash(name, size);
    }

    @Override
    public String toString() {
        return String.format("%s[%d]: %s %s %x",
                getClass().getSimpleName(), id, name, size, hashCode());
    }
}

class Dog extends Animal{

    Dog(String name, Size size) {
        super(name, size);
    }
}
class Pig extends Animal{

    Pig(String name, Size size) {
        super(name, size);
    }
}