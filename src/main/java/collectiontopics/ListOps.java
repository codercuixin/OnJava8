package collectiontopics;

import onjava.HTMLColors;

import java.util.*;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/10 15:17
 */
public class ListOps {
    static final List<String> LIST = HTMLColors.LIST.subList(0, 10);
    private static boolean b;
    private static String s;
    private static int i;
    private static Iterator<String> it;
    private static ListIterator<String> lit;

    public static void basicTest(List<String> a) {
        a.add(1, "x");
        a.add("x");
        a.addAll(LIST);
        a.addAll(3, LIST);
        b = a.contains("1");
        b = a.containsAll(LIST);

        s = a.get(1);
        i = a.indexOf("1");
        b = a.isEmpty();
        it = a.iterator();
        lit = a.listIterator();
        i = a.lastIndexOf("1");
        a.remove(1);
        a.remove("3");
        a.set(1, "y");
        a.retainAll(LIST);
        a.removeAll(LIST);
        i = a.size();
        a.clear();
    }

    public static void iterMotion(List<String> a) {
        ListIterator<String> it = a.listIterator();
        b = it.hasNext();
        b = it.hasPrevious();
        s = it.next();
        i = it.nextIndex();
        s = it.previous();
        i = it.previousIndex();
    }

    public static void iterManipulation(List<String> a){
        ListIterator<String> it = a.listIterator();
        it.add("47");
        //must move to an elment after add()
        it.next();
        //remove the element after the new one;
        it.remove();
        //must move to an element after remove
        it.next();
        //change the element after the deleted one;
        it.set("47");
    }

    public static void testVisual(List<String> a){
        System.out.println(a);
        List<String> b = LIST;
        System.out.println("b = "+b);
        a.addAll(b);
        a.addAll(b);
        System.out.println(a);

        //insert,remove, and replace elements using a listIterator
        ListIterator<String> x = a.listIterator(a.size()/2);
        x.add("one");
        System.out.println(a);
        System.out.println(x.next());
        x.remove();
        System.out.println(x.next());
        x.set("47");
        System.out.println(a);
        //traverse the list backwards
        x = a.listIterator(a.size());
        while(x.hasPrevious()){
            System.out.print(x.previous()+" ");
        }
        System.out.println();
        System.out.println("testVisual finished");
    }
    public static void testLinkedList(){
        LinkedList<String> ll = new LinkedList<>();
        ll.addAll(LIST);
        System.out.println(ll);
        //treat it like a stack, pushing:
        ll.addFirst("one");
        ll.addFirst("two");
        System.out.println(ll);
        //like "peeking" at the top of a stack;
        System.out.println(ll.getFirst());
        //like popping a stack
        System.out.println(ll.removeFirst());
        System.out.println(ll.removeFirst());
        //treat it like a queue, pulling elements off the tail end
        System.out.println(ll.removeLast());
        System.out.println(ll);
    }

    public static void main(String[] args){
        basicTest(new LinkedList<>(LIST));
        basicTest(new ArrayList<>(LIST));
        iterMotion(new LinkedList<>(LIST));
        iterMotion(new ArrayList<>(LIST));
        iterManipulation(new LinkedList<>(LIST));
        iterManipulation(new ArrayList<>(LIST));
        testVisual(new LinkedList<>(LIST));
        testLinkedList();
    }
}
