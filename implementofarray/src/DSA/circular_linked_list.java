package DSA;

import java.util.Iterator;

public class circular_linked_list<T>  {
    Node last;
        class Node{
            T data;
            Node next;
            Node(T val){
                 data=val;
                 next =null;
            }
        }
        circular_linked_list(){
            last=null;
        }
        public void insert_at_beginning(T val){
            Node newnode =new Node(val);
            if(last==null){
                newnode.next=newnode;
                last=newnode;
            }
            else{
                newnode.next=last.next;
                last.next=newnode;
            }
        }
        public void insert_at_end(T val){
            Node newnode =new Node(val);
            if(last==null){
                newnode.next=newnode;
                last=newnode;
            }
            else{
                newnode.next=last.next;
                last.next=newnode;
                last=newnode;
            }
        }
        public void display(){
            if (last==null){
                return;
            }
            Node temp=last.next;
            do {
                System.out.println(" "+temp.data);
                temp=temp.next;
            }while (temp!=last.next);
        }
        public T delete_at_beginning(){
            if(last==null){
                throw new IndexOutOfBoundsException("List is empty");
            }
            T temp =last.next.data;
            if (last.next==last){
                last=null;
            }
            else{
                last.next=last.next.next;
            }
            return temp;
        }
        public void delete_at_end(){
            if(last==null){
                throw new IndexOutOfBoundsException("List is empty");
            }
            if (last.next==last){
                last=null;
            }
            else {
                Node temp=last.next;
                while (temp.next!=last){
                    temp=temp.next;
                }
                temp.next=last.next;
                last=temp;
            }
        }
        public void delete_variable(T val){
            if (last==null){
                throw new IndexOutOfBoundsException("List is empty");
            }
            if (last.next==last){
                if (last.data.equals(val)) {
                    last = null;
                    return;
                }
            }
            if(last.next.data.equals(val)){
                last.next=last.next.next;
                return;
            }
            Node temp =last.next;
            while (temp.next!=last){
                if(temp.next.data.equals(val)){
                    temp.next=temp.next.next;
                    return;
                }
                temp=temp.next;
            }
            if(last.data.equals(val)){
                temp.next=last.next;
                temp=last;
            }
        }
        /*public void delete_variable(T val) {

    if (last == null) {
        throw new IndexOutOfBoundsException("List is empty");
    }

    Node current = last.next;
    Node previous = last;

    do {

        if (current.data.equals(val)) {

            if (current == last && current == last.next) {
                // only one node
                last = null;
            } else {
                previous.next = current.next;

                if (current == last) {
                    last = previous;
                }
            }
            return;
        }

        previous = current;
        current = current.next;

    } while (current != last.next);

    System.out.println("Value not found");
}*/
}
