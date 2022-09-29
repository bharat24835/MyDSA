package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class SortByParity2 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int []a ={2,0,3,4,1,3};
        System.out.println(" Putting even elment at even index and ");
        for(int i=0,j=1; i<a.length && j<a.length  ; j+=2 ,i+=2 )
        {
            System.out.println(" loop start");
            while (i<a.length && a[i]%2==0) i+=2; // seaching which element to be swapped (  )
            /// most probably it will give odd value
            System.out.println( " the value from first while loop is : " + a[i]);
            while(j<a.length && a[j]%2==1)  j+=2;
            System.out.println(" Valur after second while loop is  : " + a[j]);
            if(i<a.length)
                swap(a,i ,j);
        }
        System.out.println(Arrays.toString(a));

        }
    public static void swap(int []a , int b , int c)
    {
        int temp = a[b];
        a[b] = a[c];
        a[c]= temp;
    }

}

