package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class BSIN2D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [][]a = {
                {10,20,30,40},
                {15,25,35,45},
                {28,29,37,49},
                {33,34,38,50}
        };
        System.out.println("Enter the target: ");
        int target = in.nextInt();
        System.out.println(" Element found at index : ");
        System.out.println(Arrays.toString(Search2D(a,target)));

    }
    public static int[]Search2D(int[][]a, int target)
    {
        int row=0;
        int col = a[0].length -1;
        while(row <a[0].length && col>=0)
        {
            if(a[row][col] == target)
                return new int[]{row,col};
            if(a[row][col] > target)
                col--;
            else // a[row][col] < target
                row++;

        }
        return new int[] {-1,-1};
    }
}
