package com.company;

import java.util.Scanner;

public class InfiniteSortedArray {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.println(" Positiion of element in infinte sorted array:");
        int []a = { 1,2,3,4,6,7,8,9,12,23,34,45,56,67,78,89,90};
        // here we move in chunks;
        System.out.println("Enter the target:");
        int target = in.nextInt();
        int start =0;
        int count =1;
        int end =1;
        while (a[end] < target)
        {
            int temp = start;
            start = end+1;
            end = end  + (end - temp +1)*2;
            count++;
            if(end > (a.length-1))
                end = a.length-1;

        }
        System.out.println("Start is " + start);
        System.out.println("End is " + end);
        System.out.println("Chunk is " + count);
        int index = BS(a, target ,start ,end);
        System.out.println("We found the element at index" + index);


    }
    public static int BS(int []a , int target, int start , int end)
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
