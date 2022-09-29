package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RemoveElement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int []a= {0,1,2,2,3,0,4,2 ,2};
        System.out.println("enter the value");
        int target= in.nextInt();
      int k=  Process(a,target);
        System.out.println("Number of target elemtnet in array:" + k);

    }
    public static int  Process(int []a , int target)
    {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(a);
        for(int i=0; i<a.length; i++)
        {
            list.add(a[i]);
        }
        int count=0;
        int start= 0;
        int end= a.length-1;
        while(start <= end)
        {
            int mid= start + (end - start)/2;
            if(list.get(mid) > target)
                end = mid-1;
            else if(list.get(mid) < target)
                start= mid+1;
            else
            {list.remove(mid);
                end--;
                count++;
            }
        }
        System.out.println(list);
        return count;
    }
}
