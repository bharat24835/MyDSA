package DynamicProgramming;

import java.util.Arrays;

public class CountSubsetWithSumK2 {
    public static void main(String[] args) {
        int[]a = {1,2,2,3};
        int target = 5;
        int [][]dp = new int[a.length][target+1];
        for(int [] b :dp){
            Arrays.fill(b,-1);
        }
        System.out.println("Answer by Recurssion : " + call(a.length-1, target, a));
        System.out.println("Answer by Memoization : " +call2(a.length-1,target,a,dp));
        System.out.println("Answer by tabulation : " +call3(a,target));
        System.out.println("Answer by Space Optimization : " +call4(a,target));
    }
    public static int call(int i , int target, int[]a){
        if( target == 0)
            return 1;
        if(i  == 0 ) return a[0]==target ? 1:0;

        int take = 0;
        if(target - a[i] >= 0) take =call(i-1,target-a[i] ,a);
        int ignore = call(i-1, target,a);

        return take+ignore;
    }

    public static int call2( int i , int target, int[]a, int[][]dp){
        if( target == 0)
            return 1;
        if(i == 0 ) return target == a[0] ? 1:0 ;

        if(dp[i][target] != -1) return dp[i][target];

        int take = 0;
        if(target - a[i] >= 0 ) take = call2(i-1,target-a[i],a,dp);
        int ignore= call2(i-1, target, a, dp);

        return dp[i][target] = take + ignore;
    }

    public static int call3( int[]a, int target){
          int [][]dp= new int[a.length][target+1];

          for(int i = 0 ;i<a.length ; i++){
              dp[i][0] = 1;
          }
          dp[0][a[0]] = 1;

          for(int i = 1 ; i<a.length ; i++){
              for(int j = 1; j<=target; j++){
                  int take = 0;
                  if(j - a[i] >= 0 ) take= dp[i-1][j-a[i]];
                  int ignore = dp[i-1][j];

                  dp[i][j] = take+ignore;
              }
          }
          return dp[a.length-1][target];
    }

    public static int call4( int[]a, int target){
        int []prev= new int[target+1];
        prev[0] = 1;

        prev[a[0]] = 1;

        for( int i= 1; i<a.length; i++){
            int[]curr = new int[target+1];
            curr[0] =1;
            for( int j =1 ; j<=target ; j++){

                int take = 0;
                if( j - a[i] >= 0) take = prev[j-a[i]];
                int ignore = prev[j];
                curr[j] = take+ignore;
            }
            prev = curr;
        }
        return prev[target];
    }

}
