package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TriangleMinSum {
    public static void main(String[] args) {
        int m = 4 ;
        Scanner in = new Scanner(System.in);


        List<List<Integer>> t =  new ArrayList<>();
        for( int i =0 ; i<m ; i++){
            System.out.println(" Enter" + i + "th Row");
            List<Integer> inner = new ArrayList<>();
            for(int j = 0 ; j <=i ; j++){
                inner.add(in.nextInt());
            }
            t.add(new ArrayList<>(inner));
        }
        int [][] dp = new int[m][m];
        for (int[] a :
                dp) {
            Arrays.fill(a, 0);
        }

        System.out.println(" Answer By tabulation is : " + call(m , t, dp));
        System.out.println(" Answer BY Space optimizaitions is :  " + call2(m ,t));
    }
    public  static int call(int m , List<List<Integer>> t, int[][]dp ){
        // thus is tabulation
               int min = Integer.MAX_VALUE;
        for( int i =0 ; i<m ; i++){
            for(int j = 0 ; j <=i ; j++){

                if(i == 0 && j == 0){ dp[i][j] = t.get(0).get(0);
                continue;
                }
                int up = Integer.MAX_VALUE;
                int dia= Integer.MAX_VALUE;
                if( j < i )  up = dp[i-1][j];
                if( j > 0) dia= dp[i-1][j-1];

                dp[i][j] = Math.min(up ,dia) + t.get(i).get(j);
                if(i == m-1) {
                    min = Math.min(dp[i][j] , min);
                }

            }
        }
        for(int[]a : dp){
            System.out.println(a);
        }
        return min;
    }
    public static int call2( int m ,List<List<Integer>> t ){
        int min = Integer.MAX_VALUE;
        int[]ddp = new int[m];
        Arrays.fill(ddp, 0);
        for( int i =0 ; i<m ;i++){
            int []temp = new int[m];
            for (int j = 0; j<=i; j++){

                if( i == 0 && j == 0) {
                    temp[j] = t.get(0).get(0);
                    continue;
                }
                int up = Integer.MAX_VALUE;
                int dia = Integer.MAX_VALUE;
                if( j < i) up = ddp[j];
                if( j > 0) dia = ddp[j-1];

                temp[j] = Math.min(up,dia) + t.get(i).get(j);
                if( i == m-1){
                    min = Math.min(min, temp[j]);
                }
            }
            ddp = temp;
        }
        return min;
    }
}
