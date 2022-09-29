package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class MaxSubArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" Here we wish to find the max sum for a particular window size : ");
        int k = in.nextInt();
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> list = new ArrayList<>();

        int sum =0;
        int []a  = {2,3,4,1,5,9,2,3,5,-1};
        for(int i =0; i<k ;i++)
        {
            sum+=a[i];
        }
        System.out.println(" The Sum of first window is : " + sum);
        int j=0;
        for(int i = k; i<a.length; i++)
        {
            max = Math.max(sum,max);
            sum+=a[i];
            sum-=a[j++];

        }
        System.out.println(" THe max sum is : " + max);
        String d = " Bharat";
    }
}
