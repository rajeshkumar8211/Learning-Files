package DSA;
import java.lang.*;
import java.util.Iterator;

public class link_demo {
    public static void main(String[] args)  {
        linked_list <Integer>list =new linked_list<Integer>();
        list.insert_at_beginning(5);
        list.insert_at_beginning(7);
        list.display();
        list.insert_position(6,1);
        System.out.println( );
        list.display();
        list.delete_at_position(0);
        System.out.println( );
        list.display();
        list.insert_at_end(3);
        System.out.println( );
        list.display();
        list.delete_at_end();
        System.out.println( );
        list.display();
        System.out.println( );
        list.display_at_index(2);
        System.out.println( );
        list.display();
        for (int a:list){
            System.out.println(" "+a);
        }
        Iterator<Integer> it=list.iterator();
        while (it.hasNext()){
            System.out.println( it.next());
        }
    }
}
