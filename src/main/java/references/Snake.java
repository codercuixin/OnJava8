package references;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/29 16:20
 * //todo how to solve this problem
 */
public class Snake implements Cloneable {
    private Snake next;
    private char c;
    public Snake(int i, char x){
        c = x;
        if(--i>0){
            next = new Snake(i, (char)(x+1));
        }
    }
    public void increment(){
        c++;
        if(next != null){
            next.increment();
        }
    }

    @Override
    public String toString() {
        String s = ":" + c;
        if (next != null) {
            s += next.toString();
        }
        return s;
    }
    private static int countClone;
//    1.方法1

//    @Override
//    public Snake clone(){
//        try{
//            countClone++;
//            Snake res = (Snake) super.clone();
//            Snake prev = res;
//            Snake next = null;
//            Snake cur = this.next;
//            while (cur != null){
//                //无法如此使用
////                next = cur.super.clone();
//                next = cur.clone();
//                prev.next = next;
//                prev = next;
//                cur = cur.next;
//            }
//            return res;
//        } catch (CloneNotSupportedException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    方法2. 利用递归, 栈溢出错误 java.lang.StackOverflowError，比如设置列表长度10000
//     @Override
//     public Snake clone(){
//         countClone++;
//         Snake res = null;
//         try {
//             res = (Snake) super.clone();
//             if(this.next != null){
//                 res.next = this.next.clone();
//             }
//         } catch (CloneNotSupportedException e) {
//             e.printStackTrace();
//         }
//         return res;
//    }

    //doesn't work
    @Override
    public Snake clone(){
        try{
            countClone++;
            Snake res = (Snake) super.clone();
            Snake cur = res.next;
            while (cur != null){
                cur = cur.clone();
                cur = cur.next;
            }
            return res;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args){
        long start = System.nanoTime();
        Snake s = new Snake(10, 'a');
        System.out.println("s = "+s);

        Snake s2 = s.clone();
        //调用了512次，按理说只应该10次的。
        System.out.println("countClone: "+Snake.countClone);
        System.out.println("s2 = "+s2);
        s.increment();
        System.out.println("after s.increment, s = "+s);
        System.out.println("after s.increment, s2 = "+s2);
        System.out.println("cost time in nano: "+ (System.nanoTime()-start));
    }
}
