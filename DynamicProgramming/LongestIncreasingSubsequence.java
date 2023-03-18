package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {

        int[]a = {10,9,2,5,3,7,101,18};
        int n = a.length;
      //  int[]a = {0,0,0,0};
        int[][]dp = new int[a.length+1][a.length+1];
        for(int[]b: dp){
            Arrays.fill(b,-1);
        }

        System.out.println(" Here we wish to get The length of longest increasing subsequence  : ");
        System.out.println("Answer is : "  + call(0 ,a, -1, dp));
        int [][]dp1= new int[n+1][n+1];
        System.out.println("Answer by Tabulation : "  + call2(a,dp1));

        for(int[]b: dp1){
            System.out.println(Arrays.toString(b));
        }


        System.out.println("Answer By Approcah 2 method  : " + call3(a));
    }
    public static int call(int i , int[]a, int previ, int[][]dp){
        if( i == a.length)return 0;

        // here we use takeit and ignoreit method

       // we take it when it is greater than prev onee
        int takeit = Integer.MIN_VALUE;
        if(dp[i][previ+1] != -1) return dp[i][previ+1];
        if( previ>=0 && a[i] > a[previ]) takeit = 1 + call(i+1,a,i,dp);
        else{
            if(previ== -1) takeit = 1 + call(i+1,a,i,dp);
        }
        int ignoreit= 0 + call(i+1,a,previ,dp);
        return dp[i][previ+1] =  Math.max(takeit,ignoreit);
    }
//    public static int call2 (int[]a){
//        int [][]dp =new int[a.length+1][a.length+1];
//
//        // filling base case
//        for(int i = 0 ; i<=a.length; i++){
//            dp[a.length][i] = 0;
//        }
//
//        // for loops
//        for(int i  =a.length-1 ; i>=0; i--){
//            for(int j = i-1 ; j>=-1; j--){
//
//                int take = Integer.MIN_VALUE;
//                if(j>=0 && a[i] > a[j+1] ) take  = 1 + dp[i+1][i+1];
//                else{
//                    if(j== -1) take = 1 +dp[i+1][i+1];
//                }
//                int ignore = 0 + dp[i+1][j+1];
//                dp[i][j+1] = Math.max(take,ignore);
//            }
//        }
//        return dp[0][0];
//    }
    public static int call2(int[]a, int[][]dp){
        int n = a.length;


        for(int ind = n-1; ind>=0; ind --){
            for (int prev_index = ind-1; prev_index >=-1; prev_index --){

                int notTake = 0 + dp[ind+1][prev_index +1];

                int take = 0;

                if(prev_index == -1 || a[ind] > a[prev_index]){

                    take = 1 + dp[ind+1][ind+1];
                }

                dp[ind][prev_index+1] = Math.max(notTake,take);

            }
        }

        return dp[0][0];
    }

    public static int call3(int[]a){
        int n = a.length;
        int max = 1;
        int maxi = 0;
        int tmax= 0;
        int[]dp =new int[n];
        int[]hash = new int[n];
        for(int i = 0 ; i< hash.length; i++){
            hash[i] = i;
        }
        Arrays.fill(dp,1);
        for(int i = 0 ; i<n; i++){
            for(int j = 0 ; j<i ; j++){
                if(a[i] > a[j] && (1 + dp[j] > dp[i]))
                {  dp[i] = 1 + dp[j];
                    hash[i]  =  j;
                }

            }
            if(dp[i] > max){
                max = dp[i];
                maxi = i;
            }
        }

        System.out.println("");
        System.out.println("DP Array in Approcah 2 method : ");
        System.out.println(Arrays.toString(dp));
        System.out.println("Now i want print all the :");
        String temp = "";

      //  String ans = print(a,dp,temp);
        return max;
    }
    public String print(int[]a, int[]dp , String ans){
return new String("");
}
}
