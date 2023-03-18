package DynamicProgramming;

import java.util.Arrays;

public class BuyAndSellStock2 {
    public static void main(String[] args) {
        int[]a ={7,1,5,3,6,4};
        System.out.println("Here we wish to maximize our profit: ");
        int[][]dp = new int[a.length][2];
        for(int[]b: dp){
            Arrays.fill(b,-1);
        }
        System.out.println("Answer is : " + call(0,1,a, dp));
        System.out.println("Answer By Tabulation : "+ call2(a));
    }
    public static int call(int i , int flagBuy, int[]a, int[][]dp){

        if(i == a.length )return 0;
        int profit  = 0;
        if(dp[i][flagBuy] != -1 )return dp[i][flagBuy];
        if(flagBuy == 1){
            profit = Math.max((-a[i] +call(i+1,0,a,dp) ) , 0 + call(i+1, 1, a,dp));
        }
        else{
            profit = Math.max((a[i] + call(i+1,1,a,dp)) , 0 + call(i+1, 0,a,dp));
        }
        return dp[i][flagBuy] = profit;
    }

    public static int call2(int[]a){
        int[][]dp = new int[a.length+1][2];

        int buy = 1;

        // fillin base case
        for(int i = 0 ; i<=1; i++){
            dp[a.length][i] = 0;
        }
      //  int profit = 0;

        // for loops
        for(int i = a.length-1 ; i>=0 ; i--){
            for(int j = 0 ; j<2; j++){
                int profit = 0;
                if( j == 1  ){
                   profit =Math.max((-a[i] + dp[i+1][0]), 0+ dp[i+1][1]);
                }
                else{
                    profit = Math.max((a[i] + dp[i+1][1]), 0 + dp[i+1][0]);
                }
                dp[i][j] = profit;
            }
        }
        return dp[0][1];
    }

}
