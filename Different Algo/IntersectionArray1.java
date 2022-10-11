package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public  class IntersectionArray1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [] nums1= {4,9,5};
        int [] nums2= {9,4,9,8,4};
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // nums1 ka for loop chalega
        // nums2 ka BS chalega
        for(int i=0; i<nums1.length; i++)
        { boolean Add = false;
            Add =  BS(nums2 , nums1[i]);
            if(Add)
                list.add(nums1[i]);
        }
        //System.out.println(list);
        for (int i = 0; i < list.size()-1; i++)
        {
         if(list.get(i) == list.get(i+1))
         {list.remove(i);
          i--;
         }
        }

        int x = list.size();
        int []a= new int [x];
        for(int i=0; i<x ; i++)
        {
            a[i] = list.get(i);
        }
        System.out.println("Here the list" + list);
    }
    public static boolean BS(int []a , int target)
    {
        int start=0;
        int end= a.length-1;
        while(start <= end)
        {
            int mid = start + (end - start)/2;
            if(a[mid]== target)
                return true;
            else if(a[mid] < target)
                start = mid+1;
            else
                end = mid-1;
        }
        return false;
    }
}
