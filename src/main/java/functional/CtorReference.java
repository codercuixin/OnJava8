package functional;
class Dog{
    String name;
    int age  = -1;
    Dog(){
        name = "stray";
    }
    Dog(String nm){
        this.name = nm;
    }
    Dog(String nm, int yrs){
        name = nm;
        age = yrs;
    }
}
interface MakeNoArgs{
    Dog make();
}
interface Make1Args{
    Dog make(String nm);
}
interface Make2Args{
    Dog make(String nm, int age);
}
/**
 * * @Author: cuixin
 * * @Date: 2020/5/29 16:08
 */
public class CtorReference {
    public static void main(String[] args){
        MakeNoArgs mna= Dog::new;
        Make1Args m1a = Dog::new;
        Make2Args m2a = Dog::new;

        Dog dna = mna.make();
        Dog d1a = m1a.make("金毛");
        Dog d2a = m2a.make("金毛",2);

    }
}
