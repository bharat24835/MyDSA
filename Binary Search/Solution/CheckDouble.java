package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CheckDouble {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int []a = {-2,0,10,-19,4,6,-8};
        System.out.println(Arrays.toString(a));
        System.out.println(" We wish to check whether the double of numebr exist or not: ");
        Arrays.sort(a);
        int count =0;
        boolean ans = false;
        for(int i=0; i<a.length; i++)
        {
            if(a[i]==0 && count==0)
            {
                count ++;
                continue;
            }
            else
            {
                ans =  SearchBS(a,a[i]);
                if (ans)
                    break;
            }
        }
        System.out.println(" Double exist or not :" + ans);
    }
    public static boolean SearchBS(int[]a, int target)
    {
        int start =0;
        int end = a.length-1;
        target = 2* target;
        while(start <= end)
        {
            int mid= start + (end - start)/2;
            if(a[mid] > target)
                end = mid-1;
            else if(a[mid] < target)
                start = mid+1;
            else
                return true;
        }
        return false;
    }


}
