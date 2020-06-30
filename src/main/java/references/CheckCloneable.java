package references;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/29 19:17
 */
class Ordinary{}
//overrides clone, doesn't implement Cloneable
class WrongClone extends Ordinary{
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
//does all the right things for cloning
class IsCloneable extends Ordinary implements Cloneable{
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
//turn off cloning by throwing the exception
class NoMore extends IsCloneable{
    @Override
    public Object clone()throws CloneNotSupportedException{
        throw new CloneNotSupportedException();
    }
}
class TryMore extends NoMore{
    @Override
    public Object clone()throws CloneNotSupportedException{
       return super.clone();
    }
}
class BackOn extends NoMore{
    private BackOn duplicate(BackOn b){
        //somehow make a copy of b and return that copy
        //A dummy copy, just to make a point:
        return new BackOn();
    }
    @Override
    public Object clone(){
        return duplicate(this);
    }
}
//you cann't inherit form this, so you can't override clone() as you can in BackOn:
final class ReallyNoMore extends NoMore{}
public class CheckCloneable {
    public static Ordinary tryToClone(Ordinary ord){
        String id = ord.getClass().getName();
        System.out.println("Attempting "+id);
        Ordinary x = null;
        if(ord instanceof Cloneable){
            try{
                x = (Ordinary)((IsCloneable)ord).clone();
                System.out.println("cloned "+id);
            } catch (CloneNotSupportedException e) {
                System.out.println("Could not clone "+id);
            }
        }else{
            System.out.println("Doesn't implement Cloneable");
        }
        return x;
    }
    public static void main(String[] args){
        //Upcasting
        Ordinary[] ord = {
                new IsCloneable(),
                new WrongClone(),
                new NoMore(),
                new TryMore(),
                new BackOn(),
                new ReallyNoMore(),
        };
        Ordinary x = new Ordinary();
//        x.clone()
        for(Ordinary ord1: ord){
            tryToClone(ord1);
        }
    }
}
