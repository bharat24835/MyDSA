package DynamicProgramming;

import java.util.Arrays;

public class MinimumCoins2 {
    public static void main(String[] args) {
       int target = 10;
        int []a= {6,3,2};
//        int[]a = {6,3,2,5};
//        int target = 11;
       // int target = 1;
        int[][]dp = new int[a.length][target+1];
        for(int[]b : dp){
            Arrays.fill(b,-1);
        }
        System.out.println("Amswer By recurssion : " + call(a.length-1,target, a));
        System.out.println("Amswer By Memoization : " + call2(a.length-1,target, a,dp));
        System.out.println("Amswer By Tabulation : " + call3(a,target));
        System.out.println("Amswer By Space Optimization : " + call4(a,target));

    }
    public static int call( int i, int target, int[]a ){
        if(i == 0){
            if(target %a[0] == 0)return target/a[0];
            else return (int)Math.pow(10,9);
        }

        int take = (int)Math.pow(10,9);
        if(a[i] <= target) take = 1 + call(i,target - a[i], a);
        int ignore= 0 + call(i-1,target,a);
        return Math.min(take,ignore);
    }

    public static int call2( int i, int target, int[]a,int[][]dp ){
        if(i == 0){
            if(target %a[0] == 0)return target/a[0];
            else return (int)Math.pow(10,9);
        }
        if(dp[i][target]!=-1)return dp[i][target];


        int take = (int)Math.pow(10,9);
        if(a[i] <= target) take = 1 + call2(i,target - a[i], a,dp);
        int ignore= 0 + call2(i-1,target,a,dp);
        return dp[i][target] = Math.min(take,ignore);
    }
    public static int call3( int[]a, int target){
        int[][]dp = new int[a.length][target+1];

        for(int i = 0 ; i<=target; i++){
            if(i % a[0] == 0)
                dp[0][i]= i/a[0];
            else
                dp[0][i]= (int)Math.pow(10,9);
        }

        for( int i = 1 ; i<a.length; i++){
            for(int j = 0 ; j<=target; j++){
                int take = (int)Math.pow(10,9);
                if(j - a[i] >=0) take = 1 + dp[i][j-a[i]];
                int ignore = 0 + dp[i-1][j];
                dp[i][j] = Math.min(take,ignore);
            }
        }
        System.out.println("DP array after implementig : " );
        for(int[]b:dp){
            System.out.println(Arrays.toString(b));
        }
        int ans =  dp[a.length-1][target];
        if(ans >= (int)Math.pow(10,9))
            return -1;
        else return ans;
    }
    public static int call4(int[]a, int target){
        int[]prev = new int[target+1];

        for(int i= 0 ; i<=target; i++ ){
            if( i % a[0] == 0)
                prev[i] = i/a[0];
            else
                prev[i] = (int)Math.pow(10,9);
        }

        for( int i = 1 ; i<a.length; i++){
            int[]curr = new int[target+1];
            for(int j = 0 ; j<=target; j++){
                int take = (int)Math.pow(10,9);
                if(j - a[i] >=0) take = 1 + curr[j-a[i]];
                int ignore = 0 + prev[j];
                curr[j] = Math.min(take,ignore);
            }
            prev=curr;
        }
        int ans = prev[target];
        if(ans >= (int)Math.pow(10,9))
            return -1;
        else return ans;
    }

}
