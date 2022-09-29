package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class SearchInInfinteSA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" Searching in infinte sorted array: ");
        int []a = {1,2,3,4,5,6,7,8,9,11,12,13,14};
        System.out.println(Arrays.toString(a));
        System.out.println(" Enter the target BUDDY: ");
        int target= in.nextInt();
        int start = 0;
        int count =1;// count for which chunnk
        int end= 1;
        while(a[end] < target)
        {
            int temp = start;
            start = end +1;
            end = temp + (end - temp +1)*2;
            count ++;
            if(end > a.length-1)
                end = a.length-1;



        }
        int index = SIISA(a, target, start,end);
        System.out.println(" we found the elment at index : " + index);
        System.out.println(" Chunk is: " + count);

    }
    public static int SIISA(int []a , int target, int start , int end)
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
