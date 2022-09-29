package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class FirstMissingPositive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" Here we wish to find the first missing posite integer : ");
        System.out.println("  0 is not a positive integer: ");
        int[]a = {0,-5,-9,0,4,2,1,-1,-2};
        int i =0;
         while ( i<a.length)
         {
             int correctI = a[i] -1;
             if(a[i]<=a.length && a[i]!= (i+1) && a[i]>0 && a[i]!=a[correctI])
                 swap(a, i, correctI);
             else
                 i++;
         }

        System.out.println(Arrays.toString(a));
        System.out.println(" Now we wish to find the first missing positive intergre:  ");
        int j;
        for ( j = 0; j < a.length; j++) {
          if(a[j] == (j+1))
              continue;
          else {
              System.out.println(" First missing positive integer is : " +(j+1) );
              break;
          }
        }

    }
    public static void swap(int []a , int b, int c)
    {
        int temp = a[b];
        a[b]= a[c];
        a[c]= temp;
    }

}
