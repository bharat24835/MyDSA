package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class CoinChange2 {
    public static void main(String[] args) {
        int[]a = {1,2,3};
        int target = 4;
        int [][]dp = new int[a.length][target+1];
        for(int []b:dp){
            Arrays.fill(b,-1);
        }
        System.out.println("We wish the total number of ways to gives us target Sum  : " );
        System.out.println("Answer By Recurssion / Memoization : "  + call(a.length-1,target,a,dp));
        System.out.println("Answer By tabulation : "+ call2(a, target));
    }
    public static int call(int i , int target, int[]a, int[][]dp){
        if(i == 0){
            if(target % a[i] == 0) {
                return 1;
            }
            else
                return 0;

        }
        if(target == 0 )return 1;
        if(target < 0 )return 0;
if(dp[i][target] != -1)return dp[i][target];
        int take = 0;
        if(target - a[i] >=0 ) take = call(i,target-a[i],a,dp);
        int ignore = call(i-1, target, a,dp);

        return  dp[i][target] = take+ignore;
    }
    public static int call2(int []a , int target){
        // declaring dp array
        int[][]dp = new int[a.length][target+1];
        for(int j = 0 ; j<=target ; j++){
            if(j % a[0] == 0)
                dp[0][j] = 1;
//            else
//                dp[0][j]= 0;
        }

//        for(int i = 0 ; i<a.length; i++){
//            dp[i][0] = 1;
//        }

        for(int i =1; i<a.length; i++){
            for(int j = 0 ; j<=target; j++){
                int take = 0;
                if(j - a[i] >=0) take = dp[i][j - a[i]];
                int ignore= dp[i-1][j];

                dp[i][j] = take+ignore;
            }
        }
        return dp[a.length-1][target];
    }
}
