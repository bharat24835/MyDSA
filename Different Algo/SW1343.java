package com.company;

import java.util.Scanner;

public class SW1343 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [] arr = {2,2,2,2,5,5,5,8};
        int k = 3;
        int find = 4;
        System.out.println("Number of subarray of window size : " + k + " and the count is : "+ find(arr,k,find));

    }
    public static int find( int[]arr, int k , int find)
    {
     int i =0; // i hold for start of window size
        int j =0; // j hold for end of window size
        int count =0;
        int sum = 0;
        while(j<arr.length)
        {
            sum+=arr[j];
            if(j-i+1 != k) // means we didn;t hit the window size
            {
                j++;
            }
            else
            {
                if((float)sum/k >= (float)find )
                {
                    count++;
                }
                sum-=arr[i];
                i++;
                j++;
            }
        }
        return count;

    }
}
