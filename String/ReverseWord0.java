package com.company;

import java.util.Scanner;

public class ReverseWord0 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" Here we do so ");
        String s = "Let's take LeetCode contest";
        System.out.println("The answer is : " + reverseWords(s));

    }

    public static String reverseWords(String s) {

        String[] b = s.split(" ");
        StringBuilder c  = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i<b.length-1; i++)
        {
            temp.append(b[i]);
            c.append (temp.reverse()+ " ");
            temp.delete(0,temp.length());
        }

        return c.toString();
    }
}