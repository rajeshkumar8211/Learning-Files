package DSA;

public class stack{
    static final int size=30;
    int[] arr =new int[size];
    int top=-1;
    public void push(int item){
        if(top==size-1){
            System.out.println("Stack is full");
        }else{
            arr[++top]=item;
        }
    }
    public void pop(){
        int elt;
        if(top==-1){
            System.out.println("Stack is empty");
        }
        else{
            elt=arr[top];
            top--;
            System.out.println("Stack pop element is "+elt);
        }
    }
    public void peak(){
        if(top==-1){
            System.out.println("Stack is empty");
        }
        else{
            System.out.println("Stack is peak element is "+arr[top]);
        }
    }
    public void display(){
        if(top==-1){
            System.out.println("Stack is empty");
        }
        else{
            System.out.print("Stack element is");
            for (int i=0;i<=top;i++){
                System.out.print(" "+arr[i]);
            }
            System.out.println();
        }
    }
}
