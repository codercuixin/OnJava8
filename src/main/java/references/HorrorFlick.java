package references;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/29 18:25
 */
class Person{}
class Hero extends Person{}
class Scientist extends Person implements Cloneable{
    @Override
    public Scientist clone(){
        try{
            return (Scientist) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
class MadScientist extends Scientist{}
public class HorrorFlick {
    public static void main(String[] args){
        Person p = new Person();
        Hero h = new Hero();
        Scientist s = new Scientist();
        MadScientist m = new MadScientist();
//        p = p.clone();
//        h = h.clone()
        s = s.clone();
        m = (MadScientist) m.clone();
    }
}
