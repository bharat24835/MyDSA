package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" We wish to do bubble sort: ");
        int []a = {1,2,3,4,5,7,9,8};
        int count=0;
// we use count , if 

        for (int i = 0; i < a.length; i++)
        {
            for (int j = 1; j <a.length-i ; j++)
            {
              if(a[j] < a[j-1]) // swap rule
              {
                  int temp = a[j];
                  a[j]= a[j-1];
                  a[j-1] = temp;
                  count++;
              }
            }
            if(count==0)
            {
                System.out.println(" Arrays is already sorted: ");
                break;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
