package DSA;

public class circular_link_demo {
    public static void main(String[] args){
        circular_linked_list<String> list =new circular_linked_list<String>();
        list.insert_at_beginning("RAJESH");
        list.insert_at_beginning("MANOJ");
        list.insert_at_beginning("SENTHIL");
        list.insert_at_beginning("VIJI");
        list.insert_at_end("VISHWA");
        list.display();
        list.delete_at_beginning();
        System.out.println(" ");
        list.display();
        list.delete_at_end();
        System.out.println(" ");
        list.display();
        list.delete_variable("SENTHIL");
        System.out.println(" ");
        list.display();
//delval(rajesh)
//insertafter(abi)
//doublycircularlinkedlist









    }
}
