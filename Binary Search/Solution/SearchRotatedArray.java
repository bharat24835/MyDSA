package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Practise1 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        System.out.println(" Seach in rotated sorted array:");
        int []a = {3,4,5,6,7,8,10,0,1,2};
        System.out.println(" here we wish to find the target in rotated sorted array ");
        int target = in.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        // first we find the pivit  index point in RSA
        int pivit = Pivit(a);
        int index =0;
        System.out.println(" PIVIT at Index: " + pivit);
        if (target >= a[0])// first part mai search karoo
            index = BS(a, 0 ,  pivit,target);
        else
              index = BS(a, pivit+1, a.length-1,target);
        if (index!=-1)
        System.out.println(" We found the " + target + " at index " + index);
        else
            System.out.println(" sorry there is number " + target + " elemenet in the array:");
    }
    public static int Pivit(int []a)
    {
        int start=0;
        int end = a.length-1;
        while (start <= end) // here we have to check for equal condition
        {
            int mid= start + (end - start)/2;
            if( end > mid && a[mid] > a[mid+1])
                return  mid;
            if (start < mid && a[mid] < a[mid-1])
                return (mid -1);
            if(start > a[mid])
                end = mid-1;
            else
                start = mid+1;

        }
        return -1;
    }
    public static int BS(int []a, int start , int end, int target)
    {
        while(start<=end)
        {
            int mid= start + (end -start)/2;
            if(a[mid]> target)
                end = mid-1;
            else if (a[mid] < target)
                start = mid +1;
            else
                return mid;

        }
        return -1;
    }
}
