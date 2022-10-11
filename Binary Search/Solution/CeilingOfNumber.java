package com.company.Solution;

import java.util.Scanner;

public class CeilingOfNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter the order of ascendign sorted array:");
        int []a = {2,4,6,8,10,12,14};
        int target = 4;
        int start=0;

        int mid=0;
        int end = a.length-1;
        while(start <= end)
        {
           mid= start + (end-start)/2;

          if(target>a[mid])
              start= mid+1;
          else if (target<a[mid])
              end = mid-1;
          else
          {
              start = end = mid;
              break;
          }




        }

        System.out.println("ceiling of a target " + target +" is " + a[start]);
        System.out.println("Floor of a target " + target +" is " + a[end]);
    }
}
