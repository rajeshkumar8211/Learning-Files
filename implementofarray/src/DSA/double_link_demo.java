package DSA;
import java.util.*;
public class double_link_demo {
    public static void main(String[] args) {
        double_linked_list<Integer> list = new double_linked_list<Integer>();
        list.insert_at_beginning(5);
        list.insert_at_beginning(7);
        list.display();
        System.out.println(" ");
        list.displayRev();
        list.insert_position(6,1);
        list.insert_position(10,3);
        System.out.println(" ");
        list.display();
        System.out.println(" ");
        list.displayRev();
        list.delete_at_position(3);
        System.out.println(" ");
        list.display();
        System.out.println(" ");
        list.displayRev();
        list.insert_at_end(10);
        System.out.println(" ");
        list.display();
        System.out.println(" ");
        list.displayRev();
    }
}
