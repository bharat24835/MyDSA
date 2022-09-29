package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class CountingSortRelativeSortArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" Here we taking use of counting sort: ");
        int []A1 ={2,3,1,3,2,4,6,9,2,19};
        int []A2 ={2,1,4,3,9,6};
        System.out.println(" Constraints are  : " );
        System.out.println(" i<= A1[i],A2[i] <=1000 ");
        System.out.println(" If countraints are not given then we use TreesMap: ");
        int [] count = new int[1001];
        for(int n : A1)
        {
            count[n]++;
        }
        // this will increse the index of that value by numebr of times it appear:
        // now we are pasinf the element A2  in the array A1:
        int i =0;
        for(int n : A2)
        {
            while(count[n] -- >0)
                A1[i++] = n;
        }
        // now all elements  remained not in A1 need to be shit in last of arry in increasing order

        System.out.println(" now we enter the element that are not common in both ");
        System.out.println(" Index afte we put elementts : " + i);
        for(int n: A1)
        {
            while(count[n]-- > 0)
                A1[i++] =n;
        }
        System.out.println(Arrays.toString(A1));


    }
}
