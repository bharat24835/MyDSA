package Backtraking;

import java.util.Scanner;

public class NQueens2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();
        boolean [][] board = new boolean[n][n];
        System.out.println(call(board,0,0, n));
    }
    public static int call( boolean[][]board , int row, int col , int target)
    {
          if(row==board.length)
          {
              display(board);
              return 1;
          }
          int count =0;

          if(issafe(board,row,col,target))
          {
              board[row][col]=true;
              count+=call( board,  row+1,  0,  target-1);
              board[row][col]=false;
          }
          else
              count+=call(board,row, col+1,target);

          return count;
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
        return;
    }
    public static boolean issafe(boolean[][]board, int row, int col, int target)
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
}
