package DSA;

public class Trees {
    static Node root;

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data =d;
            left=null;
            right=null;
        }
    }
    public Trees(int val){
       root=new Node(val);
    }
    public void binary_tree(int d){
        root=new Node(d);
    }
    public void insertLeft(Node r,int val){
        r.left=new Node(val);
    }
    public void insertRight(Node r,int val){
        r.right=new Node(val);
    }
    public static void Pre_order(Node r){
        if (r!=null) {
            System.out.print(" "+r.data);
            Pre_order(r.left);
            Pre_order(r.right);
        }
    }
    public static void In_order(Node r){
        if (r!=null) {
            In_order(r.left);
            System.out.print(" "+r.data);
            In_order(r.right);
        }
    }
    public static void Post_order(Node r){
        if (r!=null) {
            Post_order(r.left);
            Post_order(r.right);
            System.out.print(" "+r.data);
        }
    }
    public Node insertBST(Node root,int val){
        if(root==null){
            return new Node(val);
        }
        if(val<root.data){
            root.left=insertBST(root.left,val);
        }
        else {
            root.right=insertBST(root.right,val);
        }
        return root;
    }
    public static Node searchBST(Node root,int val){
        if (root == null||root.data==val){
            return root;
        }
        if(root.data<val){
            return searchBST(root.right,val);

        }
        return searchBST(root.left, val);
    }
    public void deleteBST(int val){
        root=deleteBST(root, val);
    }
    private  Node deleteBST(Node root,int val){
        if(root==null){
            return root;
        }
        if(val<root.data){
            root.left=deleteBST(root.left,val);
        }
        else if(val> root.data) {
            root.right=deleteBST(root.right,val);
        }
        else {
            if(root.left==null){
                return root.right;
            }
            else if (root.right==null) {
                return root.left;
            }
            root.data=min(root.right);
            root.right=deleteBST(root.right,root.data);
        }
        return root;
    }
    public static int min(Node root){
        int minVal=root.data;
        while (root.left!=null){
            minVal=root.left.data;
            root=root.left;
        }
        return minVal;
    }
}
