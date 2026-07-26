package SmallPrograms;

import java.util.Scanner;

public class Start_Game {
    final char user1,user2;
    Start_Game(char user1,char user2) {
        this.user1 = user1;
        this.user2 = user2;
    }
    static char [][] xo=new char[3][3];
    static int i;
    static Scanner sc=new Scanner(System.in);
    public static void start(){
        Start_Game sg=new Start_Game('X','O');
        System.out.println("User 1 is X");
        System.out.println("User 2 is O");
        System.out.println("Positon Of The Game");
        for(i=1;i<=9;i++){
            System.out.print(" " +i);
            if (i%3==0){
                System.out.println();
            }
        }
        XO(sg.user1, sg.user2);
    }
    public static void XO(char u1,char u2){
        int a;
        for (i=1;i<=9;i++){
            if (i%2==0){
                System.out.println("Its User 2 Turn & Enter your Position");
                a=sc.nextInt();
                if(!setval(a,xo,u2)){
                    continue;
                }
                if (i>=5){
                    condition(xo);
                }
                print();
            }
            else {
                System.out.println("Its User 1 Turn & Enter your Position");
                a=sc.nextInt();
                if(!setval(a,xo,u1)){
                    continue;
                }
                print();
                if (i>=5){
                    condition(xo);
                }
            }
        }
    }
    public static void condition(char[][] xo){
        if(xo[0][0]=='X'&& xo[0][1]=='X' && xo[0][2]=='X'||
                xo[1][0]=='X' && xo[1][1]=='X' && xo[1][2]=='X'||
                xo[2][0]=='X' && xo[2][1]=='X' && xo[2][2]=='X'||
                xo[0][0]=='X' && xo[1][1]=='X' && xo[2][2]=='X'||
                xo[0][2]=='X' && xo[1][1]=='X' && xo[2][0]=='X'||
                xo[0][0]=='X' && xo[1][0]=='X' && xo[2][0]=='X'||
                xo[0][1]=='X' && xo[1][1]=='X' && xo[2][1]=='X'||
                xo[0][2]=='X' && xo[1][2]=='X' && xo[2][2]=='X'){
            System.out.println("X wins the game");
            System.exit(0);
        }
        else if(xo[0][0]=='O'&& xo[0][1]=='O' && xo[0][2]=='O'||
                xo[1][0]=='O' && xo[1][1]=='O' && xo[1][2]=='O'||
                xo[2][0]=='O' && xo[2][1]=='O' && xo[2][2]=='O'||
                xo[0][0]=='O' && xo[1][1]=='O' && xo[2][2]=='O'||
                xo[0][2]=='O' && xo[1][1]=='O' && xo[2][0]=='O'||
                xo[0][0]=='O' && xo[1][0]=='O' && xo[2][0]=='O'||
                xo[0][1]=='O' && xo[1][1]=='O' && xo[2][1]=='O'||
                xo[0][2]=='O' && xo[1][2]=='O' && xo[2][2]=='O'){
            System.out.println("O wins the game");
            System.exit(0);
        }
    }
    public static boolean setval(int val,char[][] xo,char c){
        if(val < 1 || val > 9){
            System.out.println("Invalid Position");
            return false;
        }

        int row,col;
        row=(val-1)/3;
        col=(val-1)%3;
        if(xo[row][col] != '\0'){
            System.out.println("Position already occupied");
            return false;
        }
        xo[row][col]=c;
        return true;
    }
    public static void print(){
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                System.out.print(" "+xo[i][j]+"|");
            }
            System.out.println("\n-----------------");
        }
    }
    public static void main(String[] args){
        char st;
        System.out.println("You want to start the game");
        st=sc.next().toUpperCase().charAt(0);
        if(st=='Y'){
            Start_Game.start();
        }
        else{
            System.exit(0);
        }
    }
}
