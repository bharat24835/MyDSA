package com.company;

import java.util.Scanner;

public class MajorityElement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[]a=  {1,2,2,2,3,5,5}; // edhar majority element ka size same nhi rahega
        System.out.println(" Here we wish to find the majority elemnet : ");
        int major=a[0];
        int count =1;
        for (int i=1; i<a.length; i++)
        {


                if(count==0){
                    count++;
                    major=a[i];
                }else if(major==a[i]){
                    count++;
                }else count--;

            }
            //return major;

        System.out.println(" The major element is : " + major);
    }
}
