package com.company;

import java.util.Scanner;

public class ModifiedRSA {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int[]a ={1,3};
        System.out.println(" enter the target: ");
        int target = in.nextInt();
        int index = BS(a,target,0,a.length-1);
        System.out.println(" Found element at index: " + index);

    } public static int BS(int []a ,int target, int start , int end)
    {
        while(start <= end)
        {
            int mid = start + (end - start )/2;
            if (a[mid] > target)
                end = mid-1;
            else if(a[mid] < target)
                start = mid+1;
            else
                return mid;
        }
        return -1;
    }
}
