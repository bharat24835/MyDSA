package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class CyclicSort {
    public static void main(String[] args) {
        Scanner in = new Scanner( System.in);
        int []a = {6,5,4,3,2,1};
        System.out.println(" Here we want to perform CYCLIC Sort: ");
        System.out.println(" Basic condition for this is array element lie in range of [1,N]");
        for (int i = 0; i < a.length; i++)
        {// correct position means : index = value -1
         if(a[i] == (i+1) )
             continue;
         else
         {
             swap(a,i);
             i--;
         }
        }
        System.out.println(Arrays.toString(a));
        /* int i=0;
        while (i<a.length)
        { int correct = a[i]-1;

        if(a[i] != a[correct])
        swap(a,i,correct);
        else
        i++;

        }


        * */
    }
    public static void swap(int []a , int i)
    {
        int index = a[i]-1;
        System.out.println(" Swapping between Index: "+i+"  " + index);
        int temp = a[index];
        a[index]= a[i];
        a[i]= temp;
    }
}
