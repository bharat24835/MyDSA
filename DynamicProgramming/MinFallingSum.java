package DynamicProgramming;

public class MinFallingSum {
    public static void main(String[] args) {
        int[][]a = {{2,1,3},
                {6,5,4},
                {7,8,9}
        };
        System.out.println(" answer by recurssion us : " + minFallingPathSum(a));

    }
    public static int minFallingPathSum(int[][] a) {
        int min = Integer.MAX_VALUE;

        return call2(a);

    }
//    public static int call( int i, int j , int[][]a, int[]){
    // this solution is by recurssion:
//        if( i == a.length-1) return a[i][j];
//
//        int down = Integer.MAX_VALUE ;
//        int diaLeft =Integer.MAX_VALUE;
//        int diaRight = Integer.MAX_VALUE;
//
//        if( i<a.length-1) down = call( i+1, j , a);
//        if(i <a.length-1 && j>0) diaLeft= call(i+1, j-1, a);
//        if( i< a.length-1 && j<a[0].length-1) diaRight = call(i+1, j+1, a);
//
//        return Math.min(down , Math.min(diaLeft, diaRight)) + a[i][j];
//
//
//    }

//public static int call( int i, int j , int[][]a, int[][]dp){
//        // this solution is memoization
//    if( i == a.length-1) return dp[i][j] = a[i][j];
//
//    if(dp[i][j] != -1) return dp[i][j];
//    int down = Integer.MAX_VALUE ;
//    int diaLeft =Integer.MAX_VALUE;
//    int diaRight = Integer.MAX_VALUE;
//
//    if( i<a.length-1) down = call( i+1, j , a,dp);
//    if(i <a.length-1 && j>0) diaLeft= call(i+1, j-1, a,dp);
//    if( i< a.length-1 && j<a[0].length-1) diaRight = call(i+1, j+1, a,dp);
//
//    return dp[i][j] = Math.min(down , Math.min(diaLeft, diaRight)) + a[i][j];
//
//
//}
    public static int call( int[][]a){
       int[][]dp = new int[a.length][a[0].length];
        for (int i = 0 ; i<a[0].length; i++){
            dp[0][i] = a[0][i];
        }

        for( int i =1; i<a.length; i++){
            for(int j = 0 ; j<a[0].length; j++){

                int down = Integer.MAX_VALUE ;
                int diaLeft =Integer.MAX_VALUE;
                int diaRight = Integer.MAX_VALUE;

               if( i> 0)  down= dp[i-1][j];
                if( j > 0 ) diaRight = dp[i-1][j-1];
                if( j < a[0].length-1 ) diaLeft = dp[i-1][j+1];

                dp[i][j] = Math.min(down , Math.min(diaLeft, diaRight)) + a[i][j];

            }
        }

int min = Integer.MAX_VALUE;
        for (int j =0 ; j<a[0].length; j++){
            min= Math.min(min, dp[a.length-1][j]);
        }
        return min;
    }
    public static  int call2( int[][]a){
        int[]ddp = new int[a[0].length];

        for( int i =0 ; i<a[0].length ; i++){
            ddp[i] = a[0][i];
        }

        for (int i = 1 ; i<a.length; i++){
            int[]temp  = new int[a[0].length];
            for(int j = 0; j<a[0].length ; j++){
                int down = Integer.MAX_VALUE ;
                int diaLeft =Integer.MAX_VALUE;
                int diaRight = Integer.MAX_VALUE;

                if(i > 0) down = ddp[j];
                if( j> 0) diaRight = ddp[j-1];
                if( j <a[0].length -1 ) diaLeft = ddp[j+1];

                temp[j]  = Math.min(down, Math.min(diaLeft,diaRight)) + a[i][j];


            }
            ddp = temp;
        }
        int min = Integer.MAX_VALUE;
        for( int i = 0; i<a[0].length; i++){
            min= Math.min(min , ddp[i]);
        }
        return min;
    }

}
