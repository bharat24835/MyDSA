package com.company;

import java.util.Scanner;

public class StringCharToStringASCII {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.println(" Here we wish to convert char into ascii code if form of string: ");
        String a = "Z";
        // sting a must be in uppercase letter:
        System.out.println(" Printing its sequenc numver");
        StringBuilder b = new StringBuilder();
        b.append((int) ( a.charAt(0) - 'A' +1));
        System.out.println(" Answer is: " + b);
    }
}
