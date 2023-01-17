package DynamicProgramming;

import java.util.Arrays;

public class UnBoundedKnapsack {
    public static void main(String[] args) {
        int[]wt = {2,4,6};
        int[]val = {5,11,13};
        int w = 10;
        int [][]dp = new int[wt.length][w+1];
        for(int []b: dp){
            Arrays.fill(b,-1);
        }
        System.out.println("Here we wish to provide max Value Sum : " + call(wt.length-1, w,wt,val,dp));
    }
    public static int call(int i , int w , int[]wt, int[]val, int[][]dp){
        if(i == 0){
            if( w  >=wt[0]){
                return (w/wt[0])*val[0];
            }
            else return 0;
        }
        if(dp[i][w] != -1)return dp[i][w];
        int take = Integer.MIN_VALUE;
        if(w - wt[i] >=0 ) take = val[i] + call(i,w-wt[i],wt,val,dp);
        int ignore = 0 + call(i-1,w,wt,val,dp);
        return dp[i][w] =  Math.max(take,ignore);
    }
}
