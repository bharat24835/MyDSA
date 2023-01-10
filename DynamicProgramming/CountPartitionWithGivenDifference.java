package DynamicProgramming;

import java.util.Arrays;

public class CountPartitionWithGivenDifference {
    public static void main(String[] args) {
        int[]a = {3,1,1,2,1};
        int target = 8;
        int diff= 0;


        // this questio is simple replica of Count Partition With SUm K

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

        for(int[] b:dp){
            System.out.println( Arrays.toString(b));
        }

        System.out.println("Number we wish to count the difference of partion should equal to given difference");
        int count = 0 ;
        for( int i = 0; i<=target; i++){
            int s1= i;
            int s2= target - i;
            if(Math.abs(s1-s2) == diff)count+=dp[a.length-1][i];
        }
        System.out.println("Count is : " + count);
    }
}
