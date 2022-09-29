package com.company;

import java.util.Scanner;

public class ValidPalindrone {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" Here we wish to look for valid palindrone : ");
        String s =  "race a car";
        System.out.println(" Code  answer is : "+ isPalindrome(s));
        System.out.println(" The correst answer is FALSE : ");
    }
    public static boolean isPalindrome(String s) {
        if(s.isEmpty())
            return true;
        int start =0;
        int end = s.length()-1;
        char start1 , end1;

        while(start <= end)
        {
            start1 = s.charAt(start);
            end1 = s.charAt(end);
            if( !Character.isLetterOrDigit(start1) )
            {start++;
                continue;
            }
            else if(!Character.isLetterOrDigit(end1))
            {end--;
                continue;
            }
            else
            {
                if(Character.toLowerCase(start1) != Character.toLowerCase(end1))
                    return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
