package collectiontopics;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Stream;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/12 15:47
 */
public class QueueBehavior {
    static Stream<String> strings(){
        return Arrays.stream(("one two threee four five six" +
                " seven eight nine ten").split(" "));
    }
    static void test(int id, Queue<String> queue){
        System.out.print(id +": ");
        strings().map(queue::offer).count();
        while(queue.peek()!= null){
            System.out.print(queue.remove()+" ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int count = 10;
        test(1, new LinkedList<>());
        test(2, new PriorityQueue<>());
        test(3, new ArrayBlockingQueue<>(count));
        test(4, new ConcurrentLinkedQueue<>());
        test(5, new LinkedBlockingDeque<>());
        test(6, new PriorityBlockingQueue<>());
        test(7, new ArrayDeque<>());
        test(8, new ConcurrentLinkedQueue<>());
        test(9, new LinkedBlockingDeque<>());
        test(10, new LinkedTransferQueue<>());
        test(11, new SynchronousQueue<>());
    }
}
