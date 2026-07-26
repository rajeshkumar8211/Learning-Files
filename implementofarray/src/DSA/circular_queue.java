package DSA;

public class circular_queue {

        static final int max_size=5;
        int[] arr;
        int front=-1,rear=-1;
        circular_queue(){
            arr=new int[max_size];
            front=-1;
            rear=-1;
        }
        public void enqueue(int val){
            if ((rear+1)%max_size==front){
                throw new IndexOutOfBoundsException("Queue is full");
            }
            if(front==-1){
                front++;
            }
            rear=(rear+1)%max_size;
            arr[rear]=val;
        }
        public void dequeue(){
            if (rear==-1&&front==-1){
                throw new IndexOutOfBoundsException("Queue is empty");
            }
            else {
                int elt=arr[front];
                front=(front+1)%max_size;
                if (rear==-1){
                    front=-1;
                }
            }
        }
        public void display() {
            int i = front;
            while (i != rear) {
                System.out.println(arr[i]);
                i = (i + 1) % arr.length;
            }

            System.out.print(arr[rear]);
        }
}
