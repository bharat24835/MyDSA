package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" We are searching for peak Index and then searching ");
        ArrayList<Integer> list = new ArrayList<>();
        int []a = {1,2,3,5,6,8,4,3,2};
        System.out.println(" Enter the target");
        int target= in.nextInt();
        System.out.println(" First of all we want the index of the middle element:");
        int maxi = Max(a);
        System.out.println(" Max index we found at:" + maxi+" and element is  "+ a[maxi]);
        System.out.println(" Now we have to search the target in different part of array");
        int i1= OABS(a,target,0,maxi);
        int i2 = OABS(a,target,maxi+1,a.length-1);
        if(i1 != -1)
            list.add(i1);
        if(i2 != -1)
            list.add(i2);
        System.out.println(" We found the element at index: " + list);

    }
    public static int Max(int []a)
    {
        int start = 0;
        int end = a.length-1;
        while(start < end)
        {
            int mid = start + (end - start)/2;
            if(a[mid] > a[mid+1])// this is the main reason for start<=end ,(mid+1) out of bound na jaee

                end = mid;
            else
                start = mid+1;
        }
        return end;
    }
    public static int OABS(int[]a, int target , int start, int end)
    {

        boolean IsIn = false;
                if(a[start] < a[end])
                    IsIn = true; // it means it is increasig array
        while(start<=end)
        {
            int mid = start + (end - start)/2;
            if(a[mid]== target)
                return mid;
            if(IsIn)
            {
                if(a[mid] > target)
                    end = mid-1;
                else
                    start = mid+1;
            }
            else
            {
                if(a[mid] > target)
                    start = mid+1;
                else
                    end = mid-1;
            }
        }
        return -1;
    }
}
