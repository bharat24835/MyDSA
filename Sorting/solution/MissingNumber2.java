package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class MissingNumber2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int []a = { 1,4,0,2};
        System.out.println(" RANGE IS [0,n]");
        System.out.println(" Here we wish to find the missing numebr: ");
        int i=0;
        while (i<a.length)
        {
            int correctI = a[i];
            if(a[i] < a.length && i!= a[i])
            {
                swap(a,i,correctI);
            }
            else
                i++;
        }
        System.out.println(Arrays.toString(a));

    }
    public static void swap(int []a, int b , int c)
    {
        int temp= a[b];
        a[b]= a[c];
        a[c]=temp;
    }
}
