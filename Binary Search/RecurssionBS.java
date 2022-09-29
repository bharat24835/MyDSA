package com.company;

import java.util.Scanner;

public class RecurssionBS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" Here we wish to show BS using recursion: ");
        System.out.println(" Let's GO : ");
        int []a = { 1,2,3,4,5,6};
        System.out.println(" Enter the target elemetn yu want to search: ");
        int target = in.nextInt();
        int start = 0 ;
        int end = a.length-1;
        int index = BS(a, target, start , end);
        if(index!=-1)
            System.out.println(" Found the elemnet at index : " + index);
        else
            System.out.println(" Sorry ! we didn't found the element : ");
    }
    public static int BS( int []a , int target , int start, int end)
    {
        int mid = start + (end - start)/2;
        if(start>end)
            return -1;
        if(a[mid] == target)
            return mid;
        if(a[mid] > target)
            return BS(a,target,start, mid-1);
        return BS(a,target,mid+1,end);
    }
}
