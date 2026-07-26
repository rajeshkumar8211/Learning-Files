package DSA;

public class Trees_demo {
    public static void main(String[] args){
//        Trees t=new Trees(50);
//        t.binary_tree(10);
//        t.insertLeft(t.root, 5);
//        t.insertRight(t.root, 15);
//        t.insertLeft(t.root.left, 3);
//        t.insertRight(t.root.left, 8);
//        t.insertLeft(t.root.right, 12);
//        Trees.Pre_order(t.root);
//        System.out.println("\n");
//        Trees.In_order(t.root);
//        System.out.println("\n");
//        Trees.Post_order(t.root);
//        t.insertBST(t.root,20);
//        t.insertBST(t.root,70);
//        t.insertBST(t.root,10);
//        t.insertBST(t.root,25);
//        t.insertBST(t.root,60);
//        t.insertBST(t.root,90);
//        Trees.In_order(t.root);
//        System.out.println();
//        if(t.searchBST(t.root,25)==null){
//            System.out.println("Not found");
//        }
//        else {
//            System.out.println("found");
//        }
//        t.deleteBST(60);
//        Trees.In_order(t.root);
        AVL_Tree avl=new AVL_Tree(50);
        avl.AVL_insert(20);
        avl.AVL_insert(60);
        avl.AVL_insert(10);
        avl.AVL_insert(30);
        avl.AVL_insert(40);
        avl.In_order(avl.root);
    }
}
