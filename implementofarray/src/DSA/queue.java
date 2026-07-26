package DSA;

public class queue {
    static final int max_size=30;
    int[] arr;
    int front=-1,rear=-1;
    queue(){
        arr=new int[max_size];
        front=-1;
        rear=-1;
    }
     public void enqueue(int val){
         if (rear==max_size-1){
             throw new IndexOutOfBoundsException("Queue is full");
         }
         if(front==-1){
             front++;
         }
         arr[++rear]=val;
     }
    public void dequeue(){
        if (rear==-1){
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        else {
            int elt=arr[front];
            for (int i=0;i<rear;i++){
                arr[i]=arr[i+1];
            }
            rear--;
            if (rear==-1){
                front=-1;
            }
        }
    }
    public void peek(){
         if(front==-1){
             System.out.println("Queue is Empty");
         }
         else {
                 System.out.println(" "+arr[front]);
             }
         }
    public void display() {
        if (front == -1) {
            System.out.println("Queue is Empty");
        } else {
            for (int i = 0; i <=rear; i++) {
                System.out.println(" " + arr[i]);
            }
        }
    }
}
