package com.company;

public class ReversPrefix {
    public static void main(String[] args) {
        String word = "abcvd";
        char ch = 'd';
        System.out.println(" ans is : " +reversePrefix(word, ch) );

    }
    public static String reversePrefix(String word, char ch) {
        if(!word.contains(String.valueOf(ch)) || word.length()==1 || word.charAt(0)==ch)
            return word;
        StringBuilder a = new StringBuilder();
        for( int i=0 ; i<word.length(); i++)
        {
            a.append(word.charAt(i));
            if(word.charAt(i) ==ch)
            {
                a.reverse();
                break;
            }
        }

        for( int i= a.length(); i<word.length(); i++)
        {
            a.append(word.charAt(i));
        }
        return a.toString();
    }
}

     //   "x"/
