package com.company;

import java.util.Scanner;

public class PeakMountainArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Herre we go for Peak Index in Mountain Array:");
        int []a= {1,2,4,5,9,21,34,65,32,29,21,16,12,9,4,1};
        int start=0;
        int end= a.length-1;
        while(start < end)
        {
            int mid = start + (end - start)/2;
            if (a[mid] > a[mid+1])
                // we are in decreasing part of array
                // this (mid) can be the max value, we also have to look in left part of array
                // here we cant do end= mid-1;
            {
                 end = mid;
            }
            else
            {
                start = mid + 1;
                // here we are increasing part of the array
                //
            }

        }
        System.out.println("The max element is " + a[start]);
        System.out.println("The max element is " + a[end]);
    }
}
