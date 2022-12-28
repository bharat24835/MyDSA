package DynamicProgramming;

import java.util.Arrays;

public class SusetSumEqualK {
    public static void main(String[] args) {
        int[]a ={3,2,7};
        int sum = 12;
        int[][]dp= new int[a.length][sum+1];
        for(int[]b: dp){
            Arrays.fill(b, -1);
        }


        System.out.println("Anser by Recurssion    : " + call(0 , sum ,a));
        System.out.println("Answer by Memoization  : " + call1(0 , sum,a ,dp));
        System.out.println("Answer by Tabulation   : " + call2 (a,sum));
        System.out.println("Answer by Space Optimization Technique : " + call3(a, sum));




    }
    public static boolean call (int index, int target , int[]a){

        if( target == 0 ) return true;
        if(target < 0  || index ==a.length) return false;
      //  if(index == a.length - 1) return a[a.length-1] == target;

        // take it
        boolean take = call( index+1, target - a[index],a );

        // ignore it
        boolean ignore = call( index +1, target, a);


        return take || ignore;
    }
    public static boolean call1( int index, int target, int[]a , int[][]dp){
        if( target == 0 ) return true;
        if(target < 0  || index ==a.length) return false;
        //  if(index == a.length - 1) return a[a.length-1] == target;

        if(dp[index][target] != -1)
            return dp[index][target]==0?false:true;

        // take it
        boolean take = call( index+1, target - a[index],a );

        // ignore it
        boolean ignore = call( index +1, target, a);

            dp[index][target] = (take||ignore)?1:0;
        return take || ignore;
    }

    public static boolean call2( int[]a, int k){

        // declare base case to dp
        boolean[][]dp= new boolean[a.length][k+1];

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

        for(boolean[] b : dp){
            System.out.println(Arrays.toString(b));
        }
        return dp[a.length-1][k];
        }
        public static boolean call3( int[]a , int k){

        // for every row , we want previous row
            boolean[]ddp = new boolean[k+1];
            ddp[0] = true;
              if(a[0] <=k)
                  ddp[a[0]] =true;



            for(int i = 1 ; i<a.length; i++){
                  boolean[]curr = new boolean[k+1];
                  curr[0] = true;
                for( int target =1 ; target<=k ; target++){

                    boolean take = false;

                    if(target - a[i] >=0 )
                        take = ddp[target - a[i]];
                    boolean ignore = ddp[target];

                    curr[target] = take||ignore;



                }
                ddp= curr;
            }
            return ddp[k];
        }

    }

