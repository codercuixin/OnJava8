package references;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/29 16:00
 */
//1.实现Cloenable标记接口，否则会抛出clone()会抛出异常CloneNotSupportedException
 class Duplo implements Cloneable {
     private int n;
     Duplo(int n){
         this.n = n;
     }
    //2.make your clone method public
    @Override
    public Duplo clone() {
        try {
            //3.call super.clone()
            //super.clone()方法先弄清楚对象的大小，然后为新对象创建足够的内存，
            // 然后将旧对象的所有比特位拷贝到新对象（按位拷贝 bitwise copy）
            return (Duplo) super.clone();
        }catch (CloneNotSupportedException e){
            throw new RuntimeException(e);
        }
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void increment(){
         n++;
    }

    @Override
    public String toString() {
        return Integer.toString(n);
    }
}
public class LocalCopy {
     public static Duplo g(Duplo v){
         //passing a reference, modifies outside object;
         v.increment();
         return v;
     }
     public static Duplo f(Duplo v){
         //local copy
         v = v.clone();
         v.increment();
         return v;
     }
     public static void main(String[] args){
         Duplo a = new Duplo(11);
         Duplo b = g(a);
         System.out.println("a == b: "+ (a==b) + "\na = "+a+"\nb = "+b);

         Duplo c = new Duplo(27);
         Duplo d = f(c);
         System.out.println("c == d: "+ (c==d) + "\nc = "+c+"\nd = "+d);
     }
}
