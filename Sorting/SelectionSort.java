package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int []a = { -4,2,3,4,7,8,2,5,4,1,9,8,7,6,0,2,3,4,-1};
        System.out.println(" Here we are doing the Selection Sort: ");
        for (int i = 0; i <a.length ; i++)
        {
          int end = a.length-i;

            int maxIndex = Max(a, end);
            swap(a,maxIndex,end-1); // swap between max index and last element

        }
        System.out.println(" After selection sort we do this: ");
        System.out.println(Arrays.toString(a));
    }

    public static void swap(int[] a, int maxIndex, int end)
    {
     int temp = a[maxIndex];
     a[maxIndex]= a[end];
     a[end]= temp;

    }

    private static int Max(int[] a, int end) {
        int max = 0; // assining max elelment to be first elemennt:
        int i=0;
       for( i=1; i < end; i++)
       {
           if(a[i] >a[max])
           {
               max =i;
           }
       }
       return  max;
    }
}
