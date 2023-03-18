package Practise;

import java.util.Arrays;

public class p1 {
    public static void main(String[] args) {
        int n = 7;
        int[]dp= new int[n+2];
        Arrays.fill(dp,-1);
        System.out.println(call(n, dp));
    }
    public static int call(int n, int[]dp){
        if(n == 1)return 0;

        if(dp[n]!= -1)return dp[n];
        if(n%2 == 0){
            return dp[n] = 1 + call(n/2,dp);
        }
        else{
            int left = call(n-1 ,dp);
            int right = call(n+1,dp);

            return dp[n] = 2 + Math.min(left,right);
        }
    }
}
