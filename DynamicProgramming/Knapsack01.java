package DynamicProgramming;

import java.util.Arrays;

public class Knapsack01 {
    public static void main(String[] args) {
        int w = 5;
        int []wt = {1,2,4,5};
        int []val = {5,4,8,6};
        int[]max = new int[1];
        max[0] = 0;
        int[][]dp = new int[wt.length][w+1];
        for(int[]n : dp){
            Arrays.fill(n,-1);
        }
        System.out.println("Answer by Recurssio :  "  +call(wt.length-1, w,wt,val) );
        System.out.println("Answer by Memoization : " + call2(wt.length-1, w, wt, val,dp));
        System.out.println("Answer by Tabulation : " + call3(w,wt ,val));
        System.out.println("Answer by Space Optimization : " + call4(w,wt ,val));
    }
    public static int call( int i , int target, int[]wt , int[]val  ){
        if(i == 0){
            if(target - wt[i] >= 0){
                return val[i];
            }
            else
                return 0;
        }

        int take = Integer.MIN_VALUE;
        if(target - wt[i] >= 0 )  take = val[i] + call(i-1, target - wt[i],wt,val);
        int ignore= 0 + call(i-1, target , wt , val);

        return Math.max(take , ignore);


    }

    public static int call2( int i ,  int target, int[]wt, int[]val , int[][]dp){
        if(i == 0){
            if(target - wt[i] >= 0 )
                return val[i];
            else return 0;
        }

        if(dp[i][target] != -1) return dp[i][target];

        int take = Integer.MIN_VALUE;
        if(target - wt[i] >=0) take = val[i] + call2(i-1, target - wt[i] , wt,val,dp);
        int ignore = 0 + call2(i-1, target, wt , val, dp);
        return dp[i][target] = Math.max(take,ignore);
    }

    public static int call3( int target, int[]wt, int[]val){
        // initialsing dp array
        int[][]dp = new int[wt.length][target+1];

        // fixing base case
//        if(target - wt[0] >= 0)
//            dp[0][wt[0]] = val[0];
        // this is the main difference so get the differnce
        for(int i=wt[0]; i<=target; i++){
            dp[0][i] = val[0];
        }

        for(int i= 1 ; i<wt.length; i++){
            for(int j = 0 ; j<=target;j++){
                int take = Integer.MIN_VALUE;
                if(j - wt[i]>=0) take = val[i] + dp[i-1][j-wt[i]];
                int ignore = 0 + dp[i-1][j];

                dp[i][j] = Math.max(take,ignore);
            }
        }
        return dp[wt.length-1][target];
    }
    public static  int call4(int target , int[]wt , int []val){
        int []dp = new int[target+1];

        for( int i = wt[0]; i<=target ; i++){
            dp[i] = val[0];
        }

        for(int i = 1 ; i<wt.length; i++){
            int[]curr = new int[target+1];
            for(int j = 0 ; j<= target ; j++){
                int take = Integer.MIN_VALUE;
                if(j - wt[i] >=0) take= val[i] + dp[j-wt[i]];
                int ignore = 0 + dp[j];

                curr[j] = Math.max(take,ignore);
            }
            dp=curr;
        }
        return dp[target];
    }
}
