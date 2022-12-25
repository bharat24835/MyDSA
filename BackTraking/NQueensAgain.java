package LeetCodePractise;

import java.util.Arrays;

public class NQueensAgain {
    public static void main(String[] args) {
        int n = 4;
        System.out.println("Here we wish a N queen on Nsize board such that no Queen eliminate each other: ");
        boolean[][] check= new boolean[n][n];
        String [][]show = new String[n][n];
        for (String[] b : show){
            Arrays.fill(b,"X");
        }

        System.out.println("Number of ways : " +  call(0 , n ,check,show));
    }
    public static int call( int row, int n , boolean[][]check, String[][]show){
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
                show[row][j] = "Q";
              count +=   call(row+1, n-1,check,show);
                check[row][j] = false;
                show[row][j] = "X";
            }
        }
        return count;
    }
    public static boolean isSafe( int i , int j , boolean[][]check){



        // vertical safe , means variable row, row fix
        for( int x = 0 ; x<i; x++){
            if(check[x][j] == true)
                return false;
        }
        // now check  left diagonally
        for(int x = i , y = j; x>=0 && y>=0 ; x--,y--){
            if(check[x][y] == true)
                return false;
        }
        // now check righ diagonally
        for( int x = i,y=j ; x>=0 && y<check[0].length ; x--,y++){
            if(check[x][y] == true)
                return false;
        }
        return true;
    }
}
