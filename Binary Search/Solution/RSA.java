package com.company;

import java.util.Scanner;

public class RSA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" Here we wish to find the pivit in RSA: ");
        int[]a = {8,9,10,11,1};
        System.out.println(" Lets begin it : ");
        int pI = Pivit(a);
        System.out.println(" We find the pivit at index : " + pI + " and the element is : "+a[pI]);
        System.out.println(" Now we wish to search the elemnet in our diary: ");
        int target= in.nextInt();
        int index = 0;
        if(target >= a[0])// [0.pivit ]
            index = Search(a, 0 ,pI,target);
        else
            index = Search(a,pI+1,a.length-1,target);
        if (index == -1)
            System.out.println(" Sorry! target element is not there: ");
        else
        System.out.println(" We founf the element at index : " + index);

     }
     public static int Pivit(int[]a)
     {
         int start = 0;
         int end = a.length-1;
         while(start < end)
         {
             int mid = start + (end -start)/2;
             if(a[mid] > a[mid+1])
                 return mid;
             if(a[mid-1] > a[mid] )
                 return mid-1;
             if(a[start] > a[mid])
                 end = mid-1;
             else
                 start= mid+1;
         }
         return 0;
     }
     public static int Search( int[]a , int start, int end, int target)
     {
      while(start <= end)
      {
          int mid = start + (end - start);
          if(a[mid] > target)
              end = mid-1;
          else if(a[mid] < target)
              start= mid+1;
          else
              return mid;
      }
      return -1;
     }
}
