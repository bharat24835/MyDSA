package com.company;

import java.util.Scanner;

public class SearchInRSA {

    public static void main(String[] args) {
        Scanner in = new Scanner( System.in);
        System.out.println("here we are searching in the sorted array:");
      int []a = {1,2,3};
      // we need to check for  array length for 1,2,with sorted and non sorted array
        int l = a.length;
        System.out.println(" Enter the target : ");
        int target = in.nextInt();
        int found =0;
        int pivit  = Pivit(a);
        System.out.println(" We found pivit at index :  " +  pivit);
          if(pivit!= -1)
          {
             if(a[0] > target)
                  found = BS(a,target,pivit+1,a.length-1);
             else
                  found = BS(a,target,0,pivit);
          }
          else
              found = BS(a,target,0,a.length-1);

        System.out.println(" We found the element at index : " + found);
    }
    public static int Pivit(int []a)
    {
        int start =0;
        int end = a.length-1;

        while(start <= end)
        {

            int mid = start + (end - start)/2;

            if(end > mid && a[mid] > a[mid+1])
                return mid;
            if (start < mid && a[mid] < a[mid-1])
                return (mid-1);
            if(a[start] >= a[mid])
                end = mid-1;
            else
                start = mid+1;
        }
        return  -1;
    }
    public static int BS(int []a ,int target, int start , int end)
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
