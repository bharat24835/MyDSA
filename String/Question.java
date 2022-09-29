package com.company;

import java.util.Scanner;

public class Question {
    public static void main(String[] args) {
        String a = "Hello";
        System.out.println(toLowerCase(a));

    }
    public static String toLowerCase(String s) {
        int n = s.length();
        for(int i =0 ; i<n ; i++)
        {
            if(s.charAt(i) >=65 && s.charAt(i)<=90)
                s.replace(s.charAt(i) ,(char)(s.charAt(i) + 32));

        }
        return s;

    }

}
