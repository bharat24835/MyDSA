package DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "abacde";
        String s2 = "badgek";
        System.out.println("Longest Common Sunsequenc is of Length : "  );
        int[][]dp = new int[s1.length()][s2.length()];
        for(int[]b: dp){
            Arrays.fill(b,-1);
        }
        System.out.println("Answer by Recurssion : " + call(s1.length()-1,s2.length()-1, s1,s2));
        System.out.println("Answer by Recurssion : " + call2(s1.length()-1,s2.length()-1, s1,s2,dp));
        System.out.println("Answer By tabulation : " + call3(s1,s2));
        System.out.println("Answer By tabulation : " + call4(s1,s2));



    }
    public static int call(int i , int j , String s1 , String s2){
        if(i<0 || j<0 ){
            return  0 ;
        }

        // match
        if(s1.charAt(i) == s2.charAt(j)){
            return 1 + call(i-1,j-1,s1,s2);
        }
        return 0 + Math.max(call(i-1,j,s1,s2),call(i,j-1,s1,s2));
    }

    public static int call2(int i , int j , String s1 , String s2 , int[][]dp){
        if(i<0 || j<0 ){
            return  0 ;
        }
      if(dp[i][j] != -1 )return dp[i][j];
        // match
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1 + call(i-1,j-1,s1,s2);
        }
        return dp[i][j]= 0 + Math.max(call(i-1,j,s1,s2),call(i,j-1,s1,s2));
    }

    public static int call3(String s1 , String s2){
        int [][]dp = new int[s1.length()+1][s2.length()+1];

        // declarieng base case
        for(int i = 0 ; i<=s1.length(); i++) dp[i][0] =0;
        for(int i = 0 ; i<=s2.length(); i++) dp[0][i] =0;

        // matching condition
        for( int i  =1 ; i<=s1.length(); i++){
            for(int j =1 ; j<=s2.length(); j++){

                // matching conditon
                if(s1.charAt(i-1) == s2.charAt(j-1)){  // consequenc of index shitfitn algo
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] =  0 + Math.max(dp[i-1][j] , dp[i][j-1]);
                }

            }
        }
        return dp[s1.length()][s2.length()];


    }

    public static int call4(String s1 , String s2){
        int[]prev = new int[s2.length()+1];

        // declaring base case for dp
        for(int i = 0 ; i<= s2.length(); i++)prev[i]=0;

        for(int i = 1 ; i<=s1.length(); i++){
            int[]curr = new int[s2.length()+1];
            curr[0] = 0;
            for(int j =1 ; j<=s2.length(); j++){

                // matching condisont
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                }
                else{
                    curr[j] = 0+ Math.max(prev[j] , curr[j-1]);
                }
            }
            prev = curr;
        }
        return prev[s2.length()];
    }
}
