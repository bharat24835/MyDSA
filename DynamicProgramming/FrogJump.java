package DynamicProgramming;

import java.util.Arrays;

public class FrogJump {
    public static void main(String[] args) {
        int n = 6;
        int []a = {10,10,60,10,60,50};
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1) ;
        int ans = call1( n-1 , a);
        System.out.println("Answer by Recurssion :   " + ans);
        System.out.println("Answer by Memoization : "  + call2( n-1, a, dp)); // TC optimization
        System.out.println("Answer by Tabulation : " + call3(  a, dp, n)); // SC : O(N) + O(N)
        System.out.println(" Answer by Space optimzation technique: " + call4(a,n)) ;  // SC : O(N)
    }
    public static  int call1( int index , int[]a){

        if(index==0)  return 0;

        int left =call1(index-1, a) + Math.abs(a[index] - a[index-1]);

        int right = Integer.MAX_VALUE;
        if(index>1)
            right= call1(index-2, a) + Math.abs(a[index] - a[index-2]);

        return Math.min(left,right);
    }
    public static int call2( int index, int[]a, int[] dp){
        if(index==0) return 0;
          // this function is of memoization
          // means here we use simply use of array(dp) so that we can improve the
          // TC regarding with overlapping subproblems
        if(dp[index] !=-1) return dp[index]; // solving overlapping prblems
        int left = call2(index-1, a, dp) + Math.abs(a[index] - a[index-1]);
        int right = Integer.MAX_VALUE;
        if(index > 1)
            right= call2(index-2, a,dp) + Math.abs(a[index] - a[index-2]);
        return dp[index] = Math.min(left,right);
    }
    public static int call3(  int[]a , int []dp , int n){
        dp[0] = 0;
          // here we usign tabulation technique
          // that is used to improve SC
        for( int i =1; i<n; i++){

            int first = dp[i-1]  + Math.abs(a[i] - a[i-1] );
            int second = Integer.MAX_VALUE;
            if(i>1)
                second = dp[i-2] + Math.abs(a[i] - a[i-2]);
             dp[i] = Math.min(first, second);
        }
        return dp[n-1];
    }
    public static  int call4( int []a , int n){
        // here we are using  space optimation techinique
        // SC :-  O(N) only
        // replace dp[index] stuff :- prev like variables


        int prev1 = 0;
        int prev2 = 0;
        for( int i=1 ; i<n; i++){
            int first =  prev1 + Math.abs(a[i] - a[i-1]);
            int second = Integer.MAX_VALUE;

            if(i>1)
                second = prev2 + Math.abs(a[i] - a[i-2]);
            int curri = Math.min(first,second);
            prev2= prev1;
            prev1= curri;

        }
        return prev1;

    }
}
