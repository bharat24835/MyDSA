package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" Let's try code in quick sort : ");
        int []a = {5,3,7,6,8,2,1,4};
        qs(a,0,a.length-1);
        System.out.println(" We get the sorted array as : " + Arrays.toString(a));

    }
    public static void qs( int []a , int low, int high )
    {
        if(low >= high)
            return ;
        int start = low;
        int end = high;
        int m = start + (end-start)/2;
        int pivit = a[m];

        while(start<=end)
        {
            while(a[start] < pivit)
                start++;
            while (a[end] > pivit)
                end--;
            if(start <= end)         // this step makes the entire thing
                // this step is most important
                // eskaa kaarna this algo have less
                // if the array is already sorted , it will not check it otherwise
            {
                int temp = a[start];
                a[start]= a[end];
                a[end]= temp;
                start++;
                end--;
            }
        }
        System.out.println("Pivit Index is : " + m);
        System.out.println("Pivit Element is : " + pivit);
        System.out.println("Our start is : " + start );
        System.out.println("Our End is : "+ end);
        System.out.println(Arrays.toString(a));
        System.out.println("");
        // now the pivit is at correct position that we want ;
        // now sort the right hand side as well as left side of pivit
        qs(a,low,end);
        qs(a,start,high);


    }
}
