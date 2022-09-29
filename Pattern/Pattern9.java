package com.company;

import java.util.Scanner;

public class Pattern9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" Here we wish to print the pattern 9 :  ");
        int n = in.nextInt();
        for (int i =1; i<=n; i++)
        {
            for(int j =1; j<i; j++)
            {
                System.out.print(" ");
            }
            for (int j =1; j<=2*(n-i+1)-1; j++)
            {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
