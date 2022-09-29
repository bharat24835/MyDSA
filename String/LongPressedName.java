package com.company;

import java.util.Scanner;

public class LongPressedName {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" Here we wish to codde for leetcode question long pressed naem: ");
        String name = "alex";

        String typed ="aaleexa" ;
        System.out.println(" Answer is : " + Ans(name, typed));


    }
    public static boolean Ans( String name, String typed)
    {
       int n = name.length();
       int m = typed.length();
       if(n>m)
           return false;
       int i =0;  // pointing name
       int j =0;  // pointing typed
       while( i<n && j<m)
       {
           if( name.charAt(i) == typed.charAt(j))
           {
               i++;
               j++;
           }
           else if( i>0 && name.charAt(i-1) == typed.charAt(j))
           {
               j++;
           }
           else
               return false;
       }
       while (j<m)
       {
           if(name.charAt(i-1)!= typed.charAt(j++))
               return false;
       }
       return i<name.length() ? false : true;

    }

    //"alex"
    //"aaleexa"
}
