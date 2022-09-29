package Bharat;

import java.util.Scanner;

public class MazeProblem {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.println(" Enter the starting posistion : ");
        int row= in.nextInt();
        int col= in.nextInt();
        int count = call(row,col);
        System.out.println(" Number of ways to go to [1,1]" );
        System.out.println(count);
    }
    public static int call( int row, int col)
    {
        if(row==1 || col==1)
        {
            return 1;

        }
        int right = call(row, col-1);
        int down = call(row-1, col);
        return right+down;
    }
}
