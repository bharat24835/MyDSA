package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchMountain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Here we are doing search in mountain array");
        int []a = {1,2,3,5,8,12,7,5,4,3,1};
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Enter the target:");
        int target = in.nextInt();

        int maxIndex = Max(a);
        if ((orderAGBS( a, 0,maxIndex, target)) != -1)
        list.add(orderAGBS( a, 0,maxIndex, target));
        if ((orderAGBS( a,maxIndex+1,a.length-1, target)) !=-1)
        list.add(orderAGBS( a,maxIndex+1,a.length-1, target));
        System.out.println(list);

    }
    public static int Max(int []a )
    {
        int start=0;
        int end = a.length-1;
        while(start < end)
        {
            int mid = start +  (end - start)/2;
            if(a[mid] > a[mid+1])
                // decreasing part of arrya
                end = mid;
            else
                start = mid +1;

        }
        System.out.println(" End :" + a[end]);
        System.out.println(" Start :" + a[start]);
        return end;
    }
    public static int orderAGBS(int []a,int start , int end,int target)
    {
        boolean IsIn = false;
        if(a[start] < a[end])
            IsIn = true;
        while(start <= end)
        {
            int mid= start + (end - start)/2;
            if(a[mid]== target)
                return mid;
            if(IsIn)
            {
                if (a[mid] > target)
                    end = mid-1;
                else
                    start = mid+1;

            }
            else
            {
             if(a[mid] > target)
                 start = mid+1;
             else
                 end= mid-1;
            }

        }
        System.out.println(" Print the a[end] : " + a[end]);
        System.out.println(" Print the a[start] : " + a[start]);
        return -1;
    }
}
