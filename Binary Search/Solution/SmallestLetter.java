package com.company;

import java.util.Scanner;

public class SmallestLetter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter the string array");
     //   char []a= {'a' , 'd', 'f', 'i', 'm', 'p', 't', 'w', 'y'};
        char []a= {'a' , 'a', 'a', 'a', 'a', 'a', 'a', 'w', 'y'};
        System.out.println("Enter the target :");
        String b = in.next();
        char target = b.charAt(0);

        // calling function Letter
        Letter(a,target);
    }
    public static void Letter(char []a, char target)
    {
        int start=0;
        int end = a.length-1;
        while(start <= end)
        {
            int mid= start + (end - start)/2;
            if((int)a[mid] > (int)target)
                end = mid-1;
            else if((int)a[mid] < (int)target)
                start = mid+1;
            else
            {
                start= mid+1;

            }
        }
        System.out.println("Smallest letter greater than target:" + a[start]);
    }
}
