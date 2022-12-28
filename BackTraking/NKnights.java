package LeetCodePractise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NKnights {
    public static void main(String[] args) {
        int n = 4;
        List<Integer> inner = new ArrayList<>();
        List<List<Integer>> outer = new ArrayList<>();
        System.out.println(" Number of ways to put N Knights in N*N size board" );
        boolean [][]check = new boolean[n][n];
        String[][]show = new String[n][n];
        for(String [] b: show){
             Arrays.fill(b ,".");
        }
        System.out.println("NUmber of ways : " + call(0, n , check,show));
    }
    public static int call( int row, int n , boolean[][]check ,String[][]show ){
        if(row == check.length && n == 0){
            for(String[] b : show){
                for(String a : b){
                    System.out.print(a + " ");
                }
                System.out.println("");
            }
            System.out.println("");
            return 1;
        }
        int count = 0;
        if(row == check.length && n!=0) return 0 ;

        for( int j = 0 ; j<check[0].length ; j++){

            if(isSafe( row ,  j , check)){
                check[row][j] = true;
                show[row][j] = "K";
                count +=   call(row+1, n-1,check,show);
                check[row][j] = false;
                show[row][j] = ".";
            }
        }
        return count;

    }
    public static boolean isSafe( int i , int j , boolean[][]check){

        // we have 2 option  [i-2][j +- 1]   , [i +- 1][j-2]

        // first option
        if(i-2 >= 0 && j + 1 < check.length && check[i-2][j+1] == true)
            return false;
        if(i-2 >= 0 && j - 1 >=0 && check[i-2][j-1] == true)
            return false;
        if(i-1 >= 0 && j - 2 >=0 && check[i-1][j-2] == true)
        return false;
        if(i-1 >= 0 && j + 2 < check.length && check[i-1][j+2] == true)
        return false    ;
        return true;
    }


}
