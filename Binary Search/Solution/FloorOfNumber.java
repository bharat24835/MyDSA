package com.company;

import java.util.Scanner;

public class FloorOfNumber { public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("enter the order of ascendign sorted array:");
    int n= in.nextInt();
    int []a= new int[n];
    for (int i = 0; i < n; i++)
    {
        a[i]= in.nextInt();
    }
    System.out.println("enter the target number:");
    int target= in.nextInt();
    int start=0;
    int c=0;
    int mid=0;
    int end = a.length-1;
    while(start<= end)
    {
        mid= start + (end-start)/2;
        c= mid;
        if(target>a[mid])
            start= mid+1;
        else if (target<a[mid])
            end = mid-1;
        else
        {
            c= mid+1;
            break;
        }




    }

    System.out.println("floor of a target " + target +" is " + a[c-1]);
}
}
