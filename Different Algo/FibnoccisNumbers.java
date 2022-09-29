package com.company;

import java.util.Scanner;

public class FibnoccisNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" Here we wish to find the term of fibonicci series: ");
        System.out.println(" Enter the term upto which you want to print the series: ");
        int a  = in.nextInt();
        for (int i = 0; i < a; i++) {
            System.out.print(  Fib(i)+ " ");
        }

    }
    public static int Fib(int n)
    {
        if(n==1)
            return 1;
        if(n==0)
            return 0;
        return Fib(n-1)+ Fib(n-2);
    }

}
