package DSA;

import javax.swing.*;
import java.util.*;

public class double_linked_list<T> implements Iterable<T> {

    Node head;
    Node tail;
    class  Node{
        T data;
        Node next;
        Node prev;
        Node(T val){
            data=val;
            next=null;
            prev=null;
        }
    }
    double_linked_list(){
        head=tail=null;
    }
    public void insert_at_beginning(T val){
        Node newnode= new Node(val);
        newnode.next=head;
        if(head==null){
            tail=newnode;
        }
        else {
            head.prev=newnode;
        }
        head=newnode;
    }
    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(" "+temp.data);
            temp=temp.next;
        }
    }
    public void displayRev(){
        Node temp=tail;
        while(temp!=null){
            System.out.print(" "+temp.data);
            temp=temp.prev;
        }
    }
    public void insert_position(T val,int pos){
        if(pos==0){
            insert_at_beginning(val);
            return;
        }
        Node newnode= new Node(val);
        Node temp=head;
        for (int i=1;i<pos;i++){
            temp= temp.next;
            if (temp==null){
                throw  new IndexOutOfBoundsException("invalid position "+pos);
            }
        }
        newnode.next=temp.next;
        newnode.prev=temp;
        if(temp==tail){
            tail=newnode;
        }
        else {
            temp.next.prev=newnode;
        }
        temp.next=newnode;

    }
    public void delete_at_position(int pos){
        if(head==null){
            throw new IndexOutOfBoundsException("Deletion attempted on empty list");
        }
        if (pos==0){
            head=head.next;
            if(head==null)
                tail=null;
            else
                head.prev=null;
            return;
        }
        Node temp=head;
        for (int i=1;i<pos;i++){
            temp=temp.next;
            if(temp==null){
                throw new IndexOutOfBoundsException("Deletion attempted on empty list");
            }
        }
        Node del=temp.next;
        temp.next=del.next;
        if (del==tail)
            tail=temp;
        else
            del.next.prev=temp;

    }
    public  void insert_at_end(T val){
        Node newnode =new Node(val);
        if(head==null){
            insert_at_beginning(val);
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newnode;
        newnode.prev=temp;
        tail=newnode;
    }
    public void delete_at_end(){
        if(head==null){
            throw new IndexOutOfBoundsException("Deletion attempted on empty list");
        }
        if(head.next==null){
            head=null;
            return;
        }
        Node temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
    }
    public void display_at_index(int pos){
        Node temp=head;
        for(int i=1;temp!=null;i++){
            if(i==pos){System.out.print(" "+temp.data);}
            temp=temp.next;
        }
    }
    public void reverse(){
        Node prev=null;
        Node current=head;
        Node next=head.next;
        while (current.next!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        head=prev;
    }
    public Iterator<T> iterator(){
        return new Iterator<T>(){
            Node temp=head;
            @Override
            public boolean hasNext() {
                return temp!=null;
            }

            @Override
            public T next() {
                T val=temp.data;
                temp=temp.next;
                return val;
            }
        };
    }
}
