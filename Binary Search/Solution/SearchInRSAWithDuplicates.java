    package com.company;

import java.util.Scanner;

public class SearchInRSAWithDuplicates {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("We are searching in RSA with duplicates:");
        System.out.println("It is difficult to find the pivit in duplicates");
        int []a ={9};
        int pivit = PivitWithDuplicates(a);
        System.out.println("  Pivit is : " + pivit);
        System.out.println(" Enter the target : ");
        int target = in.nextInt();
        int found =0;
        if(pivit != -1)
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
    public static int PivitWithDuplicates(int[]a)
    {
        int start=0;
        int end= a.length-1;
        while(start <= end)
        {
            int mid = start + (end - start)/2;
            if( end > mid && a[mid] > a[mid+1])
                return mid;
            if( start <mid && a[mid-1] > a[mid])
                return (mid-1);
            // now the twist arises
            // if element at mid, start,end are equal then just remove the duplicates
            // i.e start and end
            if (a[start] == a[mid] && a[end] == a[mid])
            {
                //removing start and end
                // NOTE: what if these start and end are the pivit
                //checking if start is pivit or not
                // if it is pivit , it will return start
                // otherwise remove start
                if ( start < end  && a[start] > a[start+1])
                    return start;
                start++;
                // checking if end is pivit or not
                if ( start < end && a[end] < a[end-1])
                    return (end-1);
                end--;
            }
            // left side is sorted , pivit should be in right
            else if (a[start] < a[mid] || a[start] == a[mid] && a[mid] > a[end])
                // [2,3,4,5,6,7,1] && [2,2,2,2,2,2,6]
                start= mid+1;
            else // contain [7,1,2,3,4,5]
                end = mid-1;

        }
        return -1;
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
