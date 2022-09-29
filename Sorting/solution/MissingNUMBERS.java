package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MissingNUMBERS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a = {4, 3, 2, 7,7, 8, 2, 3, 1,5,6,11,12,14};
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        System.out.println(" Range is [1,n]");
        System.out.println(" Finding the missing number when there are duplicates: ");
        int i = 0;
        while (i < a.length) {
            int correctI = a[i] - 1;
            if (a[i] != (i + 1) && a[i] != a[correctI]) { // most important line:
                swap(a, i, correctI);
            }
            else
                i++;
        }
        System.out.println(Arrays.toString(a));
        for (i=0; i<a.length;i++)
        {
            if(a[i] == i+1 )
                continue;
            else
            {
                list.add(i+1);
                list2.add(a[i]);
            }
        }
        System.out.println(" Missing elememts are : "+  list);
        System.out.println(" Repeating elements are : " + list2);

    }

    public static void swap(int[] a, int b, int c)
    {
        int temp = a[b];
        a[b]= a[c];
        a[c]= temp;

    }

}
