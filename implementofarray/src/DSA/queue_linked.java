package DSA;

public class queue_linked {
    Node head,tail;
    class Node {
        int data;
        Node next;

        Node(int val) {
            data = val;
            next = null;
        }
    }
    queue_linked(){
        head=null;
        tail=null;
    }
    public void enqueue(int val){
        Node newnode =new Node(val);
        if (head==null){
            head=tail=newnode;
            return;
        }
        else{
            tail.next=newnode;
            tail=newnode;
            return;
        }
    }
    public void dequeue(){
        if (head==null){
            throw new IndexOutOfBoundsException("List is Empty");
        }
        if (head==tail){
            head=tail=null;
        }
        else {
            head=head.next;
        }
    }
    public void display(){
        Node temp=head;
        while (temp!=null){
            System.out.println("  "+temp.data);
            temp=temp.next;
        }
    }
}
