package DynamicProgramming;

import java.util.Arrays;

public class MinimumCoins {
    public static void main(String[] args) {
        int target = 10;
        int []a= {6,3,2};
        System.out.println("Answer By Recurssion 1 : " + call(a.length-1, target, a));
        System.out.println("Answer By Recurssion 2 : " + call2(a.length-1, target, a));
        int[][]dp= new int[a.length][target+1];
        for(int[]b: dp){
            Arrays.fill(b,-1);
        }
        System.out.println("Answer By Memoization : " + call3(a.length-1,target,a,dp));
        System.out.println("Question comes to our midn what doesn dp array hold");
//        for(int[]b:dp){
//            System.out.println(Arrays.toString(b));
//        }

        System.out.println("Answer By Tabulation : " + call4(target,a));
    }
    public static int call( int i , int target, int []a){
        // there is probelm in thsi method that , when we look out at
        // array (a)  need to be in sorted order,and we star from last index
        // next let array is [1,5,6,9] , o
        // our first element is 9 , ans next coin wull be 1
        // iss case se achaa tha , that we took 6,5 denomination coins
        // kaam se kaam pura loop toh nhi ghumne padta
        if(i == 0){
            if(target -a[i] == 0)
                return 1;
            else return 0;
        }
        if( target == 0) return 1;

        int take = 0;
        if(target- a[i] >= 0 ) take = call(i,target-a[i],a);
        int ignore = call(i-1, target ,a);
        return take+ignore;
    }
    public static int call2( int i , int target, int []a){

        if(i == 0){
            if(target % a[0] == 0)
                return target/a[0];
            else return (int)Math.pow(10,9);
        }
       // if( target%a[i] == 0) return target / a[i];

        int take = (int)Math.pow(10,9);
        if(target / a[i] >0 ) take = target/a[i] +  call(i-1,target%a[i],a);
        int ignore = 0 +  call(i-1, target ,a);
        return Math.min(take,ignore);
    }
    public static int call3( int i , int target,int[]a, int[][]dp){
        if(i == 0){
            if(target%a[0] == 0)
                return target/a[0];
            else return (int)Math.pow(10,9);
        }
       // if( target%a[i] == 0) return target / a[i];
        if(dp[i][target]!= -1)return dp[i][target];

        int take = (int)Math.pow(10,9);
        if(target / a[i] >0 ) take = target/a[i] +  call(i-1,target%a[i],a);
        int ignore = 0 +  call(i-1, target ,a);
        return dp[i][target]=  Math.min(take,ignore);

    }
    public static int call4(int target, int[]a){
        int[][]dp= new int[a.length][target+1];

        for(int i= 0;i<=target; i++ ){
            if(i/a[0]>0)
            dp[0][i] = i / a[0];
            else dp[0][i] = (int)Math.pow(10,9);
        }
//        for(int i = 0 ; i<a.length; i++){
//            if(a[i] <=target)
//            dp[i][a[i]] = target/a[i];
//        }



        for(int i  = 1 ; i<a.length; i++){
            for(int j = 0; j<=target; j++){
                int take= (int)Math.pow(10,9);
                if(j /a[i] > 0 )take = j/a[i] + dp[i-1][j%a[i]];
                int ignore = 0 + dp[i-1][j];
                dp[i][j] = Math.min(take,ignore);

            }
        }
        System.out.println("Dp Array is : ");
        for(int[]b:dp){
            System.out.println(Arrays.toString(b));
        }
        return dp[a.length-1][target];
    }

}
