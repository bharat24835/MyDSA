package com.company;

import java.util.Scanner;

public class EvenDigits {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        System.out.println("find the numebr of integers  that have even digits");
        System.out.println("Enter the ordre of arrya Mform:");
        int m= in.nextInt();
       int count =0;
        int []a = new int[m];
        System.out.println("Entering the elements of an array:");
        for (int i = 0; i < m; i++) {
                a[i]= in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int num= even(a[i]);
            if(num%2==0)
                count++;
        }
        System.out.println("Mumber of elements:" + count);

    }
    public static int even(int num)
    {
        return (int) (Math.log10(num)) + 1;
    }
}
