package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class FLindexSA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" Here we wish to find the starting and last index of number");
        int []a= {1,1,2,3,4,4,4,4,4,6,8};
        System.out.println(" Enter the target: ");
        int target = in.nextInt();
        int []b =   Index(a,target);
        System.out.println(" Indexs are : ");
        System.out.println(Arrays.toString(b));
    }
    public static int[] Index(int []a, int target)
    {
        int []b = {-1,-1};
        int start = 0;
        int end = a.length-1;
        // fixing left index first
        while (start <= end)
        {
            int mid = start + (end - start)/2;
            if(a[mid] == target)
            {
                b[0]= mid;
                end = mid-1;
            }
            else if (a[mid] > target)
                end = mid-1;
            else
                start = mid+1;

        }
        start = 0;
         end = a.length-1;
        // fixing last index
        while (start <= end)
        {
            int mid = start + (end - start)/2;
            if(a[mid] == target)
            {
                b[1]= mid;
                start = mid+1;
            }
            else if (a[mid] > target)
                end = mid-1;
            else
                start = mid+1;

        }
        return b;
    }
}
