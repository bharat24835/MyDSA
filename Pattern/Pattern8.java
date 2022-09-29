package com.company;

import java.util.Scanner;

public class Pattern8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" Here we wish to print the pattern no 8 : ");
        System.out.println(" Let's Go : ");
        int n = in.nextInt();
        for(int i =1; i<=n ; i++)
        {
            for (int j =1; j<n-i+1; j++)
            {
                System.out.print(" ");
            }
            for (int j=1; j<=(2*i-1); j++)
            {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
