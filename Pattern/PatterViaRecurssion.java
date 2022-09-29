package com.company;

import java.util.Scanner;

public class PatterViaRecurssion {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" Here we wish to do an experiment: ");
        System.out.println(" Here we wish to do some expremiment:  related to some other work : ");
        System.out.println(" Enter the value  : ");
        int n= in.nextInt();
        print(n,0);
    }
    public static void print(int i , int j){

        if(i==-1)
            return ;
        if(i>=j)
        {
        print(i,++j);
            System.out.print("*");
        }
        else
        {

            print(--i,0);
            System.out.println("");
        }

    }
}
