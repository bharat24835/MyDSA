package com.company;

import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int []a= {1,3,4};
        System.out.println(" We wish to find the missing numebr from the array: ");
        int i=0;
        while (i<a.length)
        {
            int correctI = a[i]-1;
            if(  a[i] <a.length && a[i] != i+1) // STATEMENT:1- for term n hit na kare
            {
                // swapping between index i ,a[i]
                swap(a,a[i],i+1);
            }
            else
                i++;
        }
        System.out.println(" Search for the missing numebr");
        // case:1 missing a numebr in range[1,n);
        int miss = Missing(a);
        System.out.println(" Missing elememt is : " + miss);

    }

    private static int Missing(int[] a) {
        for (int j = 0; j < a.length; j++) {
            if(a[j]!=j+1)
                return j+1;
        }
        // case 2: if n is missing from the array
        // upar wala if(line 24) never hit
        return a.length;
    }

    public static void swap(int[]a , int b, int c)
    {
        int temp = a[c];
        a[c]= a[b];
        a[b]= temp;
    }

}
