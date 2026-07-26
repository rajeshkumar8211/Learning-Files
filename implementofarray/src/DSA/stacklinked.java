package DSA;

public class stacklinked {
        Node top;
        class Node{
            int data;
            Node next;

            Node(int val){
                data=val;
                next=null;
            }
        }
        stacklinked(){
            top=null;
        }
        public void push(int val){
            Node newnode=new Node(val);
            newnode.next=top;
            top=newnode;
        }
        public int pop(){
            if(top==null)
                throw new IndexOutOfBoundsException("Stack is empty");
            int elt = top.data;
            top=top.next;
            return elt;
        }
        public void peak(){
            System.out.println(" "+top.data);
        }
        public void isEmpty(){
            if(top==null)
                System.out.println("Stack is empty");
        }
        public void display(){
            Node temp=top;
            for (int i=1;temp!=null;i++){
                System.out.println(" "+temp.data);
                temp=temp.next;
            }
        }
}
