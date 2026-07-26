package DSA;

import java.util.*;

public class dynamic_array{
    final int initial_capacity=16;
    private int arr[],size,capacity;
    dynamic_array(){
        size=0;
        arr=new int[initial_capacity];
        capacity=initial_capacity;
    }
    public void add(int val){
        if(capacity==capacity) {
            expandarray();
            arr[size++] = val;
        }
    }
    public  void display(){
        for (int i =0;i<size;i++){
            System.out.println(arr[i]+" ");
        }
    }
    public void insetaspos(int val,int pos){
        if (size==0){
            arr[size++] = val;
        }
        else if(size==capacity){
            expandarray();
            for (int i=size-1;i>=pos;i--) {
                arr[i + 1] = arr[i];
            }
            arr[pos]=val;
            size++;
        }
        else{
            for (int i=size-1;i>=pos;i--) {
                arr[i + 1] = arr[i];
            }
            arr[pos]=val;
            size++;
        }
    }
    public  void deleteaspos(int pos){
        if(size==0){
            System.out.println("Array is empty");
        } else {
            for (int i=pos+1;i<size;i++){
                arr[i-1]=arr[i];
            }
        }
        size--;
        if(capacity>initial_capacity && size>3*capacity){
            shirnkarray();
        }
    }
    private void shirnkarray(){
        capacity/=2;
        arr=java.util.Arrays.copyOf(arr,capacity);
    }
    private void expandarray(){
        capacity*=2;
        arr=java.util.Arrays.copyOf(arr,capacity);
    }
    public void insertfirstposition(int val){
        if (size==0){
            arr[size++] = val;
        }
        else {
            for (int i =size;i>0;i--){
                arr[i]=arr[i-1];
            }
            arr[0]=val;
            size++;
        }
    }
    public void deleteatend(){
        int elt=arr[size];
        size--;
    }
    public void deleteatbegin(){
        for (int i=1;i<size;i++){
            arr[i-1]=arr[i];
        }
        size--;
    }
    public int search(int val){
        int i;
        for ( i=0;i<size;i++){
            if(arr[i]==val){
              return 1;
            }
        }
        return 0;
    }
    public static void main(String[] args){
        int val,choice,pos;
        dynamic_array list =new dynamic_array();
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("\n==============MENU==============\n");
            System.out.println("1.Insert at End\n2.Display the list\n3.Insert at specific position\n4.Delete at Specific Position\n5.Exit");
            System.out.println("Enter your choice");
            choice= sc.nextInt();
            switch (choice){
                case 1: {
                    System.out.println("Enter a data:");
                    val = sc.nextInt();
                    list.add(val);
                    break;
                }
                case 2:{
                    list.display();
                    break;
                }
                case 3:{
                    System.out.println("Enter a insert position(starts from 1");
                    pos = sc.nextInt();
                    if(pos<0){
                        System.out.println("invalid position");
                        break;
                    }
                    System.out.println("Enter a data:");
                    val = sc.nextInt();
                    list.insetaspos(val,pos);
                    break;
                }
                case 4:{
                    System.out.println("Enter a insert position(starts from 1");
                    pos = sc.nextInt();
                    if(pos<0){
                        System.out.println("invalid position");
                        break;
                    }
                    list.deleteaspos(pos);
                    break;
                }
                case 5:{
                    System.out.println("Enter a data:");
                    val = sc.nextInt();
                    list.insertfirstposition(val);
                    break;
                }
                case 6:{
                    list.deleteatend();
                    break;
                }
                case 7:{
                    list.deleteatbegin();
                    break;
                }
                case 8:{
                    System.out.println("Enter a data:");
                    val = sc.nextInt();
                    int a=list.search(val);
                    if (a==1){
                        System.out.println("Element is in the list");
                    }
                    else{
                        System.out.println("Element is in not the list");
                    }
                    break;
                }
                default:{
                    System.out.println("Enter a valid choice");
                }
            }
        }

    }
}
