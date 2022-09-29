package com.company;

import java.util.Arrays;

public class New2 {
    public static void main(String[] args) {
        int [][]a = {
                {1,4},
                {2,3},
                {3,4}
        };
        int []b = new int[a.length];
        b= findRightInterval(a);
        System.out.println(Arrays.toString(b));

    }
    public static  int[] findRightInterval(int[][] a) {
        int []ans = new int [a.length];
        if(a.length==1)
            return new int[]{-1};

        for(int i=0; i<a.length; i++)
        {
            ans[i]= Check(a,i);
            // i denotes the i(th) row for which we need to check
            // end of it equal or greater than start of any intervel
        }
        return ans;


    }
    public static int Check(int[][]a , int row)
    { int target = a[row][1];
        //int [] b = new int [a.length];
        // b[row] =-1;
        int min =Integer.MAX_VALUE;
        int minI =-1;
        int count=0;
        for(int j=0; j<a.length ;  j++)
        {
            if(j==row)
                continue;
            if(a[j][0] >= target)
            {
                // now we have to assign min and minI
                if(min >= a[j][0] )
                {
                    count++;
                    min = a[j][0];
                    minI = j;
                }
              // else continue;

            }
            //if(a[j][0] == target)
            //  return j;

        }
        // retuurn that indices whose elelments is
        return minI;


    }
}
