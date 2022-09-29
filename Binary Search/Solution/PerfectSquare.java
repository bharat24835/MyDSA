package com.company;

import java.util.Scanner;

public class PerfectSquare {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        System.out.println("Here we are finding whether the numebr is perfect sqare or not :");
        System.out.println("enter the number:");
        float a = in.nextInt();
        boolean ans= sqare(a);
        System.out.println("Here we done the execution ");
        System.out.println("hence whether the number is perfect square or not");
        System.out.println(ans);
    }
    public static boolean sqare(float a)
    {
        float start=1f;
        float end= a;
        while(start <= end)
        {
            float mid= start + (end - start)/2;
            if (mid== a/mid)
                return true;
            else if (mid > a/mid)
                end= (int)mid-1;
            else
                start = (int)mid+1;

        }
        return false;
    }
}
