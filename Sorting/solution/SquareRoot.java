package com.company;

import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number");
        System.out.println(" here we try to find out square root of num:");
        int num = in.nextInt();
        int start = 1;
        int end= num;
        int b=0;
        while(start< end)
        {
            int mid= start + (end - start)/2;

            if(mid <= (num/mid) && (mid+1) > (num/(mid +1))  )
            {
             b=1;
                System.out.println("Sqareroot of number is :" + mid);
                break;
            }
            else if (mid > num/mid)
                end=mid;
            else
                start= mid +1;
        }

if (b==0)
    System.out.println("Sqare root of number is :" + start);

    }
}
