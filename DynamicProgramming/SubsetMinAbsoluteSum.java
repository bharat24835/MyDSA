package DynamicProgramming;

import java.util.Arrays;

public class SubsetMinAbsoluteSum {
    public static void main(String[] args) {
        int[]a ={3,2,7};
        int sum = 12;
        System.out.println(" Minimum Absolute difference: " + call(a,sum));
    }
    public static int call( int[]a , int sum){
        int tSum = 0 ;
        for( int i = 0; i<a.length ; i++){
            tSum+=a[i];
        }
        System.out.println("Total Sum is : " + tSum);
        boolean[][]dp= new boolean[a.length][tSum+1];


        boolean dummy = call2(a,tSum,dp);
        for(boolean[] b : dp){
            System.out.println(Arrays.toString(b));
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i<=tSum; i++){
            if(dp[a.length-1][i] == true){
                int s1 = i ;
                int s2 = tSum - i;
                min = (int)Math.min(min, Math.abs(s1-s2));
            }
        }

        return min ;
    }
    public static boolean call2( int[]a, int k, boolean[][]dp){

        // declare base case to dp

        for(int  i = 0 ; i<a.length; i++){
            dp[i][0] = true;
        }
        if(a[0] <= k)
            dp[0][a[0]] = true;


        for(int i = 1 ; i<a.length; i++){

            for( int target =1 ; target<=k ; target++){

                boolean take = false;

                if(target - a[i] >=0 )
                    take = dp[i-1][target - a[i]];
                boolean ignore = dp[i-1][target];

                dp[i][target] = take||ignore;



            }
        }


        return dp[a.length-1][k];
    }


}
