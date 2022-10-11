package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class sum3closest0 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int []a = {-1,2,1,-4};
        int target = 1;
        Arrays.sort(a);
        int sum =0;
        int result =0;
        int diff = Integer.MAX_VALUE;
        System.out.println(" here we wish to find the sum of 3 numebr closeat to equal:  ");
        for (int i = 0; i < a.length-2; i++)
        {
            int start =0;
            int end= a.length-1;

            while(start < end)
            {
                sum =a[i] +a[start] +a[end];
                if(Math.abs(target - sum) > Math.abs(diff))
                { diff = target - sum;
                    result= sum;

                }
                if (sum > target)
                    end --;
                else start++;

            }
        }
        System.out.println(" The sum is : " + sum);
    }
}
