package com.company;

import java.util.Scanner;

public class Palindrone {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" Here we wish to check whether the string is palindrone orr not: ");
        String name = "abcc";
        boolean ans = IsPalindrone( name);
        System.out.println( " string is palindrone: ");
        System.out.println(ans);
    }
    public static boolean IsPalindrone ( String name)
    {
        int start = 0;
        int end = name.length()-1;
        while ( start <= end)
        {
            if (name.charAt(start) == name.charAt(end)) {

                start++;
                end--;
                continue;
            }
            else
                return false;

        }
        return true;
    }
}
