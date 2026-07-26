package DSA;

public class circular_double_list <T>{
    Node head,tail;
    class Node{
        T data;
        Node prev;
        Node next;
        public Node(T val){
            data=val;
            prev=null;
            next=null;
        }
    }
    circular_double_list(){
        head=tail=null;
    }
    public void insert_at_beginning(T val){
        Node newnode = new Node(val);
        if(head == null){
            newnode.next=newnode;
            newnode.prev=newnode;
            head=newnode;
            tail=newnode;
        }
        else {
            newnode.next=head;
            head.prev=newnode;
            head=newnode;
            tail.next=head;
            head.prev=tail;
        }
    }
    public void displayRev(){
        if (head==null){
            return;
        }
        else {
            Node temp =tail;
            do{
                System.out.println(" "+temp.data);
                temp=temp.prev;
            }while(temp!=tail);
        }
    }
    public void display(){
        if (head==null){
            return;
        }
        else {
            Node temp =head;
            do{
                System.out.println(" "+temp.data);
                temp=temp.next;
            }while(temp!=head);
        }
    }
    public void insert_at_end(T val){
        Node newnode = new Node(val);
        if(head == null){
            newnode.next=newnode;
            newnode.prev=newnode;
            head=newnode;
            tail=newnode;
        }
        else{
            newnode.next=head;
            newnode.prev=tail;
            tail.next=newnode;
            head.prev=newnode;
            tail=newnode;
        }
    }
    public void insert_at_position(T val,int pos){
        if(pos==0){
            insert_at_beginning(val);
            return;
        }
        else {
            Node newnode = new Node(val);
            Node temp = head;
            for(int i=1;i<pos;i++){
                if (temp==tail){
                    throw  new IndexOutOfBoundsException("invalid position "+pos);
                }
                temp=temp.next;
            }
            newnode.next=temp.next;
            newnode.prev=temp;
            if(temp==tail){
                head.prev=newnode;
                tail=newnode;
            }else {
                temp.next.prev=newnode;
            }
            temp.next=newnode;
        }
    }
    public void delete_at_beginning(){
        if(head==null){
            System.out.println("List is empty ");
            return;
        }
        if(head==tail){
            head=null;
            tail=null;
        }
        else{
            head=head.next;
            head.prev=tail;
            tail.next=head;
        }
    }
    public void delete_at_end(){
        if(head==null){
            System.out.println("List is empty ");
            return;
        }
        if(head==tail){
            head=null;
            tail=null;
        }
        else{
            Node temp=head;
            while (temp.next!=tail){
                temp=temp.next;
            }
            temp.next=head;
            tail=temp;
            head.prev=temp;
        }
    }
    public void delete_at_position(int pos){
        if (head==null){
            throw new IndexOutOfBoundsException("List is empty");
        }
        if(head==tail){
            head=tail=null;
            return;
        }
        if (pos < 0) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        if(pos==0){
            delete_at_beginning();
            return;
        }
        else {
            Node temp=head;
            for (int i=1;i<pos;i++){
                if (temp==tail){
                    throw  new IndexOutOfBoundsException("invalid position "+pos);
                }
                temp=temp.next;
            }
            if (temp.next==tail){
                delete_at_end();
                return;
            }
            temp.next=temp.next.next;
            temp.next.prev=temp;
        }
    }
    public void delete_at_value(T val){
        if(head==null){
            throw new IndexOutOfBoundsException("List is Empty");
        }
        if(head==tail&&head.data.equals(val)){
            head=tail=null;
            return;
        }
        Node temp = head;
        if(temp.data.equals(val)){
            head=head.next;
            tail.next=head;
            head.prev=tail;
            return;
        }
        while (temp.next!=head&&temp.next!=tail) {
            if (temp.next.data.equals(val)) {
                temp.next=temp.next.next;
                temp.next.prev=temp;
                return;
            }
            temp=temp.next;
        }
        if(temp.next==tail&&temp.next.data.equals(val)){
            temp.next=head;
            tail=temp;
            head.prev=temp;
        }else{
            System.out.println("Value not found");
        }
    }
}
