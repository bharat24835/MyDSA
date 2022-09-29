package com.company;

import java.util.Scanner;

public class Mytwosum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int []a = new int[2];
        int []nums = new int[4];
        int target;
        System.out.println("Enter the arrray");
        for (int i = 0; i < nums.length; i++) {
            nums[i]= in.nextInt();
        }
        System.out.println("Here we take input array");
        System.out.println("Enter the target:");
        target = in.nextInt();

        int b=0;

        for (int i=0; i<nums.length-1; i++)
        {
            if(b==0)

                for(int j=1; (j>i)&& (j<nums.length); j++)
                {
                    if(nums[i]+nums[j]==target)
                    {
                        a[0]= i;
                        a[1]= j;
                        b=1;
                        break;
                    }// end of if loop
                }//end of for j
            else break;
        }//end of for i
        for (int i = 0; i < 2; i++) {
            System.out.print(a[i]);

        }


    }
}
