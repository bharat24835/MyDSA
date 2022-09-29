package com.company;

import java.util.Scanner;

public class SeachInMA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the mountain array:");
        int []a = {1,3,5,8};
       //` System.out.println("Enter the target:");
      //  int target= in.nextInt();
        // first of all we want to seach the index of bigger element
        int maxI = Max(a);
        System.out.println("max found at index " +maxI+" and element is "+ a[maxI] );
    }
    public static int Max(int[]a)
    { int mid=0;
        int start= 0;
        int end= a.length-1;
        while (start<end)
        {
            mid = start + (end - start)/2;
            if( a[mid] > a[mid+1])
                end = mid;
            else
                start= mid+1;

        }
        return start;
    }
}
