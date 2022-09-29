package com.company;

public class stringbuilder {
    public static void main(String[] args) {
        System.out.println(" Here we learn the concept of String Buildre: ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char ch = (char)('a' + i);
            builder.append(ch);
        }
        System.out.println(builder);
        System.out.println(" Now we wish to do some operation : ");
        System.out.println(" Deleting of particular char of index: ");
        System.out.println(builder.deleteCharAt(0));
        
    }
}
