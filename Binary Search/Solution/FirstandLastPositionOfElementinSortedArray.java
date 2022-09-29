package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class FirstandLastPositionOfElementinSortedArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter the order of ascendign sorted array:");
        int n= in.nextInt();
        int []a= new int[n];
        for (int i = 0; i < n; i++)
        {
            a[i]= in.nextInt();
        }
        System.out.println("enter the target number:");
        int target= in.nextInt();
        int []ans= kunalgreat(a, target);
        System.out.println("indices are :");
        System.out.println(Arrays.toString(ans));
    }
    public static int[] kunalgreat(int []a , int target)
    {
        int []ans= {-1,-1};
        //for first index we are searching for
        int start = 0;
        int end = a.length-1;
        while (start<=end)
        {
            int mid = start + (end - start)/2;
            if (target== a[mid])
            {
                ans[0]=mid;
                //here we are again cheicking for left side
                end=mid-1;
            }
            else if( target > a[mid])
                start= mid+1;
            else
                end= mid-1;
        }

        //agian checking for right side checking for some good stuff
         start=0;
         end= a.length-1;
        while(start<=end)
        {
            int mid = start + (end - start)/2;
            if (target== a[mid])
            {
                ans[1]=mid;
                //here we are again cheicking for right side
                start= mid+1;
            }
            else if( target > a[mid])
                start= mid+1;
            else
                end= mid-1;
        }
        return  ans;
    }
}
