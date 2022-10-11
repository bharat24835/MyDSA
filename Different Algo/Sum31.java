package com.company;

import java.util.*;

public class Sum31 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            Set<List<Integer>> list = new HashSet<>();

        int []a = {-4,-1,-1,0,1,2 };
        int lRow =0;
        System.out.println(" Here we wish to find the pair of 3 whose sum is 0");
        for(int i=0 ; i<a.length-2; i++)
        {
            int start = i+1;
            int end = a.length-1;
            while(start < end)
            {
                if(a[start] + a[end ] + a[i] > 0)
                    end --;
                else if(a[start] + a[end] + a[i] <0)
                    start++;
                else {
                    list.add(Arrays.asList(a[i] ,a[start++] ,a[end--]));
                }
            }
        }
        System.out.println(" The list is " + list);

    }
}
