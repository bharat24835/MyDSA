package DynamicProgramming;

import java.util.Arrays;

public class CherryPickUpII {
    public static void main(String[] args) {
        int[][]a ={{3,1,1},
                   {2,5,1},
                   {1,5,5},
                   {2,1,1}};
        int[][][]dp = new int[a.length][a[0].length][a[0].length];
        for( int[][]b : dp ){
            for(int[]c : b){
                Arrays.fill(c ,-1);
            }
        }
       System.out.println(" Answer by Recurssion  ;  " +  call( 0,0,a[0].length-1, a));
        System.out.println(" Anwer by Memoization : " + call2(0,0,a[0].length-1 ,a,dp));
        System.out.println(" Answer by Tabulation: " + call3(a));
        System.out.println(" Answer by Tabulation 2 : " +call4(a));
        System.out.println(" Answer by Space Optimization  : " + call5( a));

    }
    public static int call( int i , int j1, int j2 , int[][]a){
        if( j1 < 0 || j1>=a[0].length || j2 < 0 || j2 >= a[0].length){
            return Integer.MIN_VALUE;
        }
      if(i == a.length-1){
         if(j1 == j2) {
             return a[i][j1];
         }
         else
             return a[i][j1] + a[i][j2];
      }

      int max = Integer.MIN_VALUE;
        int down = Integer.MIN_VALUE;
        int diaLeft = Integer.MIN_VALUE;
        int diaRight = Integer.MIN_VALUE;

      for( int q = -1 ; q<=1; q++){
          int ans = 0;
          if( j1+q >= 0)    down = call(i+1,j1+q, j2 ,a);
          if(j1+q >= 0 && j2 > 0)    diaLeft = call(i+1, j1+q, j2-1,a);
          if(j1+q <=a[0].length-1 && j2<a[0].length-1) diaRight =call(i+1, j1+q,j2+1, a);


          if(j1 == j2){
              ans= Math.max(down,Math.max(diaLeft,diaRight)) + a[i][j1];
          }
          else {
              ans= Math.max(down,Math.max(diaLeft,diaRight)) + a[i][j1] + a[i][j2];
          }
          max = Math.max(ans,max);

      }
      return max;


    }

    public static int call2( int i , int j1 , int j2 , int[][]a, int[][][]dp){
        if( j1 < 0 || j1>=a[0].length || j2 < 0 || j2 >= a[0].length){
            return Integer.MIN_VALUE;
        }
        if(i == a.length-1){
            if(j1 == j2) {
                return   a[i][j1];
            }
            else
                return a[i][j1] + a[i][j2];
        }
           if(dp[i][j1][j2]!= -1)  return dp[i][j1][j2];
        int max = Integer.MIN_VALUE;
        int down = Integer.MIN_VALUE;
        int diaLeft = Integer.MIN_VALUE;
        int diaRight = Integer.MIN_VALUE;

        for( int q = -1 ; q<=1; q++){
            int ans = 0;
            if( j1+q >= 0 && j1+q <=a[0].length-1)    down = call2(i+1,j1+q, j2 ,a,dp);
            if(j1+q >= 0 && j1+q <=a[0].length-1 && j2 > 0)    diaLeft = call2(i+1, j1+q, j2-1,a,dp);
            if( j1+q >= 0 &&j1+q <=a[0].length-1 && j2<a[0].length-1) diaRight =call2(i+1, j1+q,j2+1, a,dp);


            if(j1 == j2){
                ans= Math.max(down,Math.max(diaLeft,diaRight)) + a[i][j1];
            }
            else {
                ans= Math.max(down,Math.max(diaLeft,diaRight)) + a[i][j1] + a[i][j2];
            }
            max = Math.max(ans,max);

        }
        dp[i][j1][j2]=max;
        return max;

    }

    public static int call3( int[][]a){
        int[][][] dp  =  new int[a.length][a[0].length][a[0].length];
        int m = a.length;
        int n= a[0].length;
//        int max = Integer.MIN_VALUE;
//        int down = Integer.MIN_VALUE;
//        int diaLeft = Integer.MIN_VALUE;
//        int diaRight = Integer.MIN_VALUE;

        // declaring base cases
        for(int  j1 = 0 ;j1<n; j1++ ){
            for (int j2 = 0 ; j2<n; j2++){

                if(j1 == j2){
                    dp[m-1][j1][j2] = a[m-1][j1];
                }
                else{
                    dp[m-1][j1][j2] = a[m-1][j1] + a[m-1][j2];
                }
            }
        }

        // that was our base case

        for( int i = m-2 ; i>=0; i--){
            for(int j1 = 0 ; j1<n; j1++){
                for (int j2 = 0 ; j2 < n ;  j2++){
                    int max = Integer.MIN_VALUE;
                    int down = Integer.MIN_VALUE;
                    int diaLeft = Integer.MIN_VALUE;
                    int diaRight = Integer.MIN_VALUE;


                     // let fix ROBO 1 , be q variable
                    // then for a particualr move of robo1 , there will be three moves of Robo 2
                    for( int q = -1 ; q<=1; q++){
                        int ans = 0;
                        if( j1+q >= 0 && j1+q <=a[0].length-1)    down = dp[i+1][j1+q] [j2 ];
                        if(j1+q >= 0 && j1+q <=a[0].length-1 && j2 > 0)    diaLeft = dp[i+1][ j1+q] [j2-1];
                        if( j1+q >= 0 && j1+q <=a[0].length-1 && j2<a[0].length-1) diaRight =dp[i+1][ j1+q][j2+1] ;


                        if(j1 == j2){
                            ans= Math.max(down,Math.max(diaLeft,diaRight)) + a[i][j1];
                        }
                        else {
                            ans= Math.max(down,Math.max(diaLeft,diaRight)) + a[i][j1] + a[i][j2];
                        }
                        max = Math.max(ans,max);

                    }
                    dp[i][j1][j2]=max;

                }
            }
        }
        return dp[0][0][n-1];
    }
    public static int call4( int[][]grid){
        int n = grid.length;
        int m = grid[0].length;
        int dp[][][] = new int[n][m][m];

        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2)
                    dp[n - 1][j1][j2] = grid[n - 1][j1];
                else
                    dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
            }
        }

        //Outer Nested Loops for travering DP Array
        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {

                    int maxi = Integer.MIN_VALUE;

                    //Inner nested loops to try out 9 options
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {

                            int ans;

                            if (j1 == j2)
                                ans = grid[i][j1];
                            else
                                ans = grid[i][j1] + grid[i][j2];

                            if ((j1 + di < 0 || j1 + di >= m) ||
                                    (j2 + dj < 0 || j2 + dj >= m))

                                ans += (int) Math.pow(-10, 9);
                            else
                                ans += dp[i + 1][j1 + di][j2 + dj];

                            maxi = Math.max(ans, maxi);
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }

        return dp[0][0][m - 1];
    }
    public static  int call5( int [][]a){
        int[][] dp  =  new int[a[0].length][a[0].length];

        int m = a.length;
        int n= a[0].length;
        int[][]curr = new int[n][n];
//        int max = Integer.MIN_VALUE;
//        int down = Integer.MIN_VALUE;
//        int diaLeft = Integer.MIN_VALUE;
//        int diaRight = Integer.MIN_VALUE;

        // declaring base cases
        for(int  j1 = 0 ;j1<n; j1++ ){
            for (int j2 = 0 ; j2<n; j2++){

                if(j1 == j2){
                    dp[j1][j2] = a[m-1][j1];
                }
                else{
                    dp[j1][j2] = a[m-1][j1] + a[m-1][j2];
                }
            }
        }

        // that was our base case

        for( int i = m-2 ; i>=0; i--){
            for(int j1 = 0 ; j1<n; j1++){
                for (int j2 = 0 ; j2 < n ;  j2++){
                    int max = Integer.MIN_VALUE;
                    int down = Integer.MIN_VALUE;
                    int diaLeft = Integer.MIN_VALUE;
                    int diaRight = Integer.MIN_VALUE;


                    // let fix ROBO 1 , be q variable
                    // then for a particualr move of robo1 , there will be three moves of Robo 2
                    for( int q = -1 ; q<=1; q++){
                        int ans = 0;
                        if( j1+q >= 0 && j1+q <=a[0].length-1)    down = dp[j1+q] [j2 ];
                        if(j1+q >= 0 && j1+q <=a[0].length-1 && j2 > 0)    diaLeft = dp[ j1+q] [j2-1];
                        if( j1+q >= 0 && j1+q <=a[0].length-1 && j2<a[0].length-1) diaRight =dp[ j1+q][j2+1] ;


                        if(j1 == j2){
                            ans= Math.max(down,Math.max(diaLeft,diaRight)) + a[i][j1];
                        }
                        else {
                            ans= Math.max(down,Math.max(diaLeft,diaRight)) + a[i][j1] + a[i][j2];
                        }
                        max = Math.max(ans,max);

                    }
                    curr[j1][j2]=max;

                }
            }
            for (int x = 0; x< n; x++) {
                dp[x] = (int[])(curr[x].clone());
            }



    }
        return dp[0][n-1];

    }
}
