package DSA;

public class AVL_Tree {
    Node root;

    static class Node {
        int data;
        Node left, right;
        int height;

        Node(int d) {
            data =d;
            left=null;
            right=null;
            height=0;
        }
    }
    public AVL_Tree(int val){
        root=new Node(val);
    }

    public AVL_Tree(){root = null;}

    public void AVL_insert(int val){
        root=AVL_insert(root,val);
    }

    private static int getheight(Node node){
        if(node==null){
            return -1;
        }
        return node.height;
    }
    private static int max(int a,int b){
        return a>b?a:b;
    }
    private static Node AVL_insert(Node root, int val){
        if(root==null){
            return new Node(val);
        }
        if(val<root.data){
            root.left=AVL_insert(root.left,val);
        }
        else if(val>root.data) {
            root.right=AVL_insert(root.right,val);
        }
        else{
            return root;
        }
        root.height=1+max(getheight(root.left),getheight(root.right));

        int balFactor = getBalanceFactor(root);
        //LL case
        if (balFactor>1&&val<root.left.data){
            return rightRotate(root);
        }
        //LR case
        if (balFactor>1&&val>root.left.data){
            root.left=leftRotate(root.left);
            return rightRotate(root);
        }
        //RL case
        if (balFactor<-1&&val<root.right.data){
            root.right=rightRotate(root.left);
            return leftRotate(root);
        }
        //RR case
        if (balFactor<-1&&val>root.right.data){
            return leftRotate(root);
        }
        return root;
    }
    private static int getBalanceFactor(Node root){
        if (root==null){
            return 0;
        }
        return getheight(root.left)-getheight(root.right);
    }

    private static Node rightRotate(Node z){
        Node y=z.left;
        Node t3=y.right;
        y.right=z;
        z.left=t3;
        z.height=1+max(getheight(z.left),getheight(z.right));
        y.height=1+max(getheight(y.left),getheight(y.right));
        return y;
    }
    private static Node leftRotate(Node z){
        Node y=z.right;
        Node t3=y.left;
        y.left=z;
        z.right=t3;
        z.height=1+max(getheight(z.left),getheight(z.right));
        y.height=1+max(getheight(y.left),getheight(y.right));
        return y;
    }
    public void In_order(Node r){
        if (r!=null) {
            In_order(r.left);
            System.out.println(r.data+" height is "+r.height);
            In_order(r.right);
        }
    }
}
