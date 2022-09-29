package com.company;

import java.util.Scanner;

public class RomanNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the string:");
        String s = in.nextLine();
        int sum=0;
        int tsum=0;
        char a = 'A';
int l= s.length();
        for (int i = 0; i < s.length()-1; i++) {
          if(Roman(s.charAt(i)) >= Roman(s.charAt(i+1)))
                     sum = sum + Roman(s.charAt(i));
           else
              sum = sum - Roman(s.charAt(i));

        }
        sum = sum + Roman(s.charAt(s.length()-1));
        System.out.println(" The sum is ; " + sum);
    }
    public static int Roman(char a)
    {
        switch (a)
        {
            case 'I':
            {
                return 1;
            }
            case 'V':
            {
                return 5;
            }
            case 'X':
            {
                return 10;
            }
            case 'L':
            {
                return 50;
            }
            case 'C':
            {
                return 100;
            }
            case 'D':
            {
                return 500;
            }
            case 'M':
            {
                return 1000;
            }
        }
        return 0;
    }
}
