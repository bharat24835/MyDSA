package com.company;

import java.util.Scanner;

public class MaximumRepeatingSubstring1668 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

      String sequence = "ababc";
      String word = "ab";
        System.out.println(" Counte is "  + maxRepeating(sequence,word));
    }
    public static int maxRepeating(String sequence, String word) {
        int n = sequence.length();
        int m = word.length();
        int k=0; // pointer for string word ;
        int counter =0;
        int max =0;
        for ( int i =0  ; i<n; i++)
        { k =0; counter=0;

            for( int j =i; j<n; j++ )// j is here to say flow start searching the sequence from ith index
            {
                if(sequence.charAt(j) == word.charAt(k))
                    k++;
                else
                    break;
                if(k==m)
                {
                    ++ counter ;
                    k=0;
                }


            }
            max = Math.max(max, counter);
        }
        return max;

    }
}
//
