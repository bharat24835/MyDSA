package com.company;

import java.util.Scanner;

public class StringASCIIcodetoStringChar {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = "26";
        System.out.println(" Now we wish to convert this String into string of char : ");
        StringBuilder b = new StringBuilder();
        int i= 1;
        b.append((char)('A' + (a.charAt(i)-'0') + 10*(a.charAt(i-1) - '0')  -1));// this line will change the output from lowercase to uppercase
        System.out.println(b);
        //((char)('a' + (s.charAt(i-1) -'0' ) + 10*(s.charAt(i-2)-'0') -1) )
    }
}
