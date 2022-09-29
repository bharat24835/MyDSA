package Backtraking;

import java.util.Arrays;
import java.util.Scanner;

public class NQueen {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();
        boolean [][] board = new boolean[n][n];
        System.out.println(call(board,0));
    }

    public static  int call( boolean[][]board , int row)
    {
        if(row==board.length )
        {
            display(board);
            System.out.println("");
            return 1;
        }
        int count =0;
        for (int col = 0; col < board[0].length; col++) {
            if (Issafe(board,row,col))
            {
                board[row][col]=true;
                count+=call(board,row+1);
                board[row][col]=false;
            }


        }
        return count;
    }
    public static boolean Issafe(boolean[][]board, int row, int col)
    {
        // checking verticcal row
        for (int i=0; i<row; i++)
        {
            if (board[i][col])
                return false;
        }

        // checking left diagonal
        int maxleft =Math.min(row,col);
        for (int j = 1; j <= maxleft ; j++) {
            if (board[row-j][col-j])
                return false;
        }

        // chexking rigth diagonal
        int maxright = Math.min(row, (board[0].length-col-1));
        for (int k = 1; k <=maxright ; k++) {
            if (board[row-k][col+k])
                return false;
        }
        return true;
    }
    public static void display(boolean[][] board)
    {
        for ( boolean[] a:board ) {
            for (boolean b :a) {
                if (b)
                    System.out.print("Q ");
                else
                    System.out.print("X ");
            }
            System.out.println("");
        }
    }

}
