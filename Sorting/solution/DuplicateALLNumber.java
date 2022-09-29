package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DuplicateALLNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" Here we wish to find the duplicate from the array: ");
        int []a = {1,2,2,3,3,6,7};
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(" Range is from [i,n] , contain (n+1) integer");
        System.out.println(Arrays.toString(a));
        System.out.println(" First of all we need to sort this array: ");
        int i=0;
        while (i<a.length)
        {
            int correctI = a[i]-1;
            if(a[i] !=(i+1) && a[i] != a[correctI])
            {
                swap(a,i,correctI);


            }
            else
                i++;
        }
        System.out.println(" Sorted array is : " + Arrays.toString(a));
       // System.out.println(" Duplicate element is : " + a[a.length-1]);
        // duplicate numbe hamesh last mai shift ho jata hai
        for (int j = 0; j < a.length; j++) {
            if(a[j] != j+1)
                list.add(a[j]);
        }
        System.out.println(" Duplicate number are: " + list) ;

    }
    public static void swap(int[]a , int b, int c)
    {
        int temp = a[b];
        a[b]=a[c];
        a[c]= temp;
    }

}
