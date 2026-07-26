package DSA;

public class queue_demo {
    public static void main(String[]args){
       /* queue_linked qu=new queue_linked();
        qu.enqueue(1);
        qu.enqueue(2);
        qu.enqueue(3);
        qu.display();
        qu.dequeue();
        qu.display();*/
        queue qu=new queue();
        qu.enqueue(1);
        qu.enqueue(2);
        qu.enqueue(3);
        qu.display();
        qu.dequeue();
        qu.display();
        qu.peek();

    }
}
