package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class LinearSearchRecurssion {
    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
        int [] a = { 3,2,4,1,4,5,4,6,8};
        System.out.println(" ENTER THE TARGET : " );
        int target = in.nextInt();
        int index =ls(a,target,0);
        if( index==-1)
            System.out.println(" Sorry no elemet found: ");
        else
            System.out.println(" found element at index : " + index);
        System.out.println(" If we wish to print all the index where target element occur: ");
       LS(a,target,0);
        System.out.println(list);
    }
    static ArrayList<Integer> list = new ArrayList<>();
    public static int ls( int []a , int target , int start)
    {
        if(start == a.length)
            return -1;
        if(a[start] == target)
            return start;
        else
            return ls(a,target,++start);
    }
    static void LS(int[]a , int target, int start){

        if(start == a.length)
            return ;
        if(a[start] == target)
            list.add(start);

             LS(a,target,++start);
    }
}
