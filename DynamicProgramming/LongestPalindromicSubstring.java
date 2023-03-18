package DynamicProgramming;

import java.util.Arrays;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s1 = "aacabdkacaa";
       // String s1 = "aaaabbaa";
     //     String s1 = "babad";
       // String s1 = "aabaa";
        String s2 = "";
        for(int i = 0 ; i<s1.length(); i++){
            s2 = s1.charAt(i) + s2;
        }
        System.out.println(call(s1));
        System.out.println(" Try usign recurssion : " + call2(0,s1.length()-1,s1));

    }
    public static String call(String s1){
        int n = s1.length();
        int[][]dp = new int[n][n];
        int maxlegth = 0;
        String ans ="";
        Pair temp = new Pair(0,0);

        for(int diff = 0 ; diff<n ; diff++){

            for(int i = 0,  j = i+diff ; j<n; i++, j++){
                if(i == j){
                    dp[i][j]  = 1;

                }
                else if(diff == 1){
                    dp[i][j] = (s1.charAt(i)==s1.charAt(j)) ? 2:0;
                }
                else{
                    if(s1.charAt(i) == s1.charAt(j) && dp[i+1][j-1]!= 0){
                        dp[i][j] = dp[i+1][j-1]+2;
                    }
                }
                if(dp[i][j] >  maxlegth){
                    maxlegth = dp[i][j];
                    temp.i = i;
                    temp.j = j;
                }

            }

        }
        for(int []b :dp){
            System.out.println(Arrays.toString(b));
        }
        System.out.println("String start from : " + temp.i);
        System.out.println("String end at : " + temp.j);


        return  s1.substring(temp.i,temp.j+1);
    }

    public static int  call2(int i , int j , String s1  ){
        if(i>j)return  0;


        if( i == j){
            return 1;
        }
        else if( j - i == 1){
            return s1.charAt(i) == s1.charAt(j) ? 2:0;
        }
        else{
            if(s1.charAt(i) == s1.charAt(j) && call2(i+1, j-1,s1) !=0){
                return call2(i+1, j-1, s1) + 2;
            }
            else
                return Math.max(call2(i+1, j , s1), call2(i, j-1, s1));
        }
    }
}

