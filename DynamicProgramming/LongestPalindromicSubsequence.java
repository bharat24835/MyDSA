package DynamicProgramming;


import java.util.Arrays;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s1 = "bbabcbcab";
        String s2 ="";
        StringBuilder sb = new StringBuilder();
        sb.append(s1);
        sb.reverse();
        s2 = sb.toString();
     //   System.out.println(s2);
        System.out.println("Here we wish to get Longest Palindronmic Subsequence:  " );
        int [][]a = call3(s1,s2);
        for(int[]c:a){
            System.out.println( Arrays.toString(c));
        }
        int  s = a[s1.length()][s2.length()];

        StringBuilder ans  = new StringBuilder();

        int i = s1.length();
        int j= s2.length();
        while( i> 0 && j> 0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                ans.insert(0,s2.charAt(j-1));
                i--;
                j--;
            }
            else if(a[i][j-1] > a[i-1][j]){
                j--;
            }
            else i--;

        }
        System.out.println("Common Longst subsequence is : " + ans);

    }
    public static int[][] call3(String s1 , String s2){
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
        return dp;


    }

}
