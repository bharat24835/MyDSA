package com.company;

import java.util.Scanner;

public class RBSRecurssioon {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" Here we wish to use algo binary search in rotated array : ");
        int []a  ={5,6,7,8,9,1,2,3 } ;
        System.out.println(" Enter the target elemtnet to be searched: ");
        int target = in.nextInt();
        System.out.println(BS(a,target,0,a.length-1));
    }
    public static int BS(int[]a, int target , int s, int e)
    {
        if(s>e)
            return -1;
        int m  = s + (e-s)/2;
        if(a[m] == target)
            return m;
        if(a[s]<=a[m]) // 7 8 9 10 11 1 2
        {
            if(target >= a[s] && target<=a[m])
                return BS(a,target,s,m-1);
            else
                return BS(a,target,m+1,e);
         }
        else // { 7,8,1,2,3,4,5,6}
        {
            if(target >= a[m] &&  target <=a[e])
               return BS(a,target,m+1,e);
            else
               return BS(a,target,s,m-1);
        }
    }
}
