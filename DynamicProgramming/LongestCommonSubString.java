package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestCommonSubString {
    public static void main(String[] args) {
        String s1 = "abcjklpefgh";
        String s2 = "acjkpefgh";

        System.out.println("LOngest Common Substring : " + call( s1,s2));
    }
    public static int call(  String s1 , String s2){
        int[][]dp =new int[s1.length()+1][s2.length()+1];
        int m = s1.length();
        int n = s2.length();
        int max = 0;
        Pair item = new Pair(0,0);
        for(int i =1 ; i<=m; i++){
            for(int j=1 ; j<=n ; j++){

                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                if(max < dp[i][j]){
                    item.i = i;
                    item.j = j;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println("DP Array is : ");
        for(int []b: dp){
            System.out.println(Arrays.toString(b));
        }
        System.out.println("Maximum Found at Index : " + item.i + " " + item.j);
        String ans = "";

        int i = item.i;
        int j = item.j;
        while( i>=1 && j>=1 ){
            if(dp[i][j] == 0)break;

            ans = s2.charAt(j-1)+ans;
            i--;
            j--;
        }
        System.out.println("NOw we wish to print the common part: " + ans);


        return max;
    }
}
class  Pair{
    int i ;
    int j;
    Pair(int x, int y){
        this.i = x;
        this.j = y;
    }
}
