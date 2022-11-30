package DynamicProgramming;

import java.util.Arrays;

public class Fib1 {
    public static void main(String[] args) {
        int n =5;
        int ans = call( n);
        int []dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(" Answer by Recurssion call :   "+ans);
        System.out.println(" Answer by Memoization:  " + call2(n, dp) );
        System.out.println(" Answer by tabulation :  " + call3(n));
        System.out.println(" Answer by space optimization technique:  " + call4(n));
    }
    public static int call( int n){
        if(n<=1)
            return n;
        return call(n-1) + call(n-2);

    }
    public static int call2(int n, int[]dp){
        if(n<=1)return n;
        if (dp[n]!=-1)return dp[n];

        int first = call2(n-1,dp);
        int second = call2(n-2,dp);
        return dp[n] = first + second;




    }

    public static int call3( int n){

        int [] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for( int i =2; i<=n ; i++){
            dp[i] = dp[i-1] + dp[i-2];

        }
        return dp[n];
    }

    public static int call4( int n){
        int p1 =1;
        int p2 = 0 ;
        for( int i =2; i<=n; i++){
            int temp = p1+p2;
            p2 = p1;
            p1 = temp;
        }
        return p1;
    }
}


