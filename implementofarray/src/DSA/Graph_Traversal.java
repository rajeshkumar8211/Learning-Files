package DSA;

public class Graph_Traversal {
       public static void main(String[] args){
           int[] [] graph ={
                   {0,1,0,0,1},
                   {1,0,1,0,1},
                   {0,1,0,1,0},
                   {0,0,1,0,1},
                   {1,1,0,1,0}
           };
           Graph_list gl=new Graph_list(5);
           gl.add(0,1);
           gl.add(0,4);
           gl.add(1,2);
           gl.add(1,4);
           gl.add(2,3);
           gl.add(3,4);
           gl.print();
           gl.bfs(0);
           gl.dfs(0);
       }
}