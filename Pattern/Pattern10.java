package com.company;

import java.util.Scanner;

public class Pattern10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" Here we wish to print pattern 10 : ");
        int n = in.nextInt();
        for(int i =1; i<=n ; i++)
        {
            for (int j =1; j<n-i+1; j++)
            {
                System.out.print(" ");
            }
            for (int j=1; j<=i; j++)
            {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }
}
