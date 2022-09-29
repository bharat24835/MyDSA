package Backtraking;

import java.util.Scanner;

public class CountingPath {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" Enter rows and colums: ");
        int row= in.nextInt();
        int col= in.nextInt();
        int ans =call(row, col);
        System.out.println(" Number of ways are : "+ ans);
    }
    public static int call(int row, int col)
    {
        if(row==1 || col==1)
            return 1;
        int right= call(row,col-1);
        int down = call(row-1,col);
        return (right+down);
    }
}
