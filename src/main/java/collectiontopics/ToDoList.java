package collectiontopics;

import java.sql.SQLSyntaxErrorException;
import java.util.PriorityQueue;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/12 15:59
 */
public class ToDoList {
    public static void main(String[] args){
        PriorityQueue<ToDoItem> toDoItems = new PriorityQueue<>();
        toDoItems.add(new ToDoItem("Empty trash", 'C', 4));
        toDoItems.add(new ToDoItem("Feed dog", 'A', 2));
        toDoItems.add(new ToDoItem("Feed bird", 'B', 7));
        toDoItems.add(new ToDoItem("Mow lawn", 'C', 3));
        toDoItems.add(new ToDoItem("Water lawn", 'A', 1));
        toDoItems.add(new ToDoItem("Feed cat", 'B', 1));
        while (!toDoItems.isEmpty()){
            System.out.println(toDoItems.remove());
        }
    }
}
class ToDoItem implements Comparable<ToDoItem>{
    private char primary;
    private int secondary;
    private String item;
    ToDoItem(String td, char pri, int sec){
        primary = pri;
        secondary = sec;
        item = td;
    }
    @Override
    public int compareTo(ToDoItem o) {
        if(primary > o.primary){
            return +1;
        }
        if(primary == o.primary){
            if(secondary > o.secondary){
                return +1;
            }else if(secondary == o.secondary){
                return 0;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return Character.toString(primary)+ secondary+": "+item;
    }
}