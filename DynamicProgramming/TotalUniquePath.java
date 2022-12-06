package DynamicProgramming;

import java.util.Arrays;

public class TotalUniquePath {
    public static void main(String[] args) {
        int m = 3;
        int n = 3;

        System.out.println("Answer by Recurssion : " + call(m-1, n-1));
        int [][]dp = new int[m][n];
        for(int [] p :dp){
            Arrays.fill(p ,-1);
        }
        System.out.println(" Answer by Memoization : " + call2( m-1, n-1, dp));
        for(int [] p :dp){
            Arrays.fill(p ,0);
        }
        System.out.println(" Answer by Tabulation  : " + call3(m, n, dp));

        int[]dummyDP = new int[n];
        System.out.println(" Answer by Space Optimizatiom  " + call4(m,n,dummyDP));


    }
    public static int call( int i , int j){
         if( i==0 && j==0)  return 1;
         if(i <0 || j<0) return 0;

         int left = call(i,j-1);
         int up = call(i-1, j);
         return  left + up;
    }
    public static int call2( int i , int j , int[][]dp){
        if( i == 0  && j==0) return 1;
        if( i < 0 || j< 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int left = call2(i ,j-1, dp);
        int up = call2(i-1,j,dp );
        return dp[i][j] = left + up;


    }
    public static int call3( int m , int n , int[][]dp){

        for(int i =0 ; i<m; i++){
            for(int j= 0 ; j<n; j++ ){
                if(i ==0  && j==0 ) dp[i][j] = 1;
               else{
                    int left =0;
                    if(j >0 )  left= dp[i][j-1];
                    int up = 0;
                    if(i>0) up = dp[i-1][j];

                    dp[i][j] = up + left;
                }
            }
        }
        return dp[m-1][n-1];
    }
    public static int call4(int m , int n, int[]dummyDP){

        // this duummy dp will take care about the up task  , means hold the previous row value
        Arrays.fill(dummyDP , 0);

        for(int i =0; i<m ; i++){

            int []temp = new int[n];

            for (int j =0 ; j<n ; j++) {
                if (i == 0 && j == 0) temp[j] = 1;
                else {
                    int up = 0;
                    if (i > 0)
                        up = dummyDP[j];
                    int left = 0;
                    if (j > 0)
                        left = temp[j - 1];

                    temp[j] = up + left;

                }
            }
            dummyDP = temp;

        }
        return dummyDP[n-1];
    }


}
