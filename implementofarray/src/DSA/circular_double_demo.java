package DSA;

public class circular_double_demo {
    public static void main(String[] args){
        circular_double_list<String> list=new circular_double_list<String>();
        list.insert_at_beginning("RAJESH");
        list.insert_at_beginning("MANOJ");
        list.display();
        System.out.println(" ");
        list.displayRev();
        System.out.println(" ");
        list.insert_at_end("SENTHIL");
        list.display();
        System.out.println(" ");
        list.displayRev();
        System.out.println(" ");
        list.insert_at_position("VIJI",1);
        list.display();
        System.out.println(" ");
        list.displayRev();
        System.out.println(" ");
        list.insert_at_position("JEYA",0);
        list.display();
        System.out.println(" ");
        list.displayRev();
        System.out.println(" ");
        list.insert_at_position("SUVA",5);
        list.display();
        System.out.println(" ");
        list.displayRev();
        System.out.println(" ");
        list.delete_at_beginning();
        list.display();
        System.out.println(" ");
        list.displayRev();
        System.out.println(" ");
        list.delete_at_end();
        list.display();
        System.out.println(" ");
        list.displayRev();
        System.out.println(" ");
        list.delete_at_position(2);
        list.display();
        System.out.println(" ");
        list.displayRev();

    }
}
