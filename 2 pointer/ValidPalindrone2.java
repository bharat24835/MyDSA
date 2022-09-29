package com.company;

public class ValidPalindrone2 {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(" The correct answer is : TRUE ");
        System.out.println(" My answer is : " + validPalindrome(s));
    }

    public static boolean validPalindrome(String s) {
        int start =0;
        int end = s.length()-1;
        int count1 =0; // left parsing
        int count2= 0 ; // right parsing
        // this question is little bit like start and end index of an element in sorted array
        // where we parse for left index and right index differently
        // 1st left parsing
        while(start <=end)
        {
            if(s.charAt(start) != s.charAt(end))
            {
                start++;
                count1++;
            }
            else
            {
                start++;
                end--;
            }

        }
        if(count1 <2)
            return true;
        // 2nd right parsing
         start =0;
         end = s.length()-1;

        while(start <=end)
        {
            if(s.charAt(start) != s.charAt(end))
            {
                end--;
                count2++;
            }
            else
            {
                start++;
                end--;
            }

        }
        if(count2 <2)
            return true;

        return false;

    }
}
