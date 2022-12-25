package Practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p7 {
    public static void main(String[] args) {
        boolean[][] check = {{true,true,true},
                             {false ,true,true},
                             {true,true,true}};
        int[][]show = {{0,0,0},
                {0,0,0 },
                {0,0,0}};


        int m = 3;
        int n = 3;
        String ans = "";

        System.out.println("Total number of ways" + call(0,0, m,n,check,ans, show,1));

    }
    public static  int call( int i , int j ,int m , int n , boolean[][]check , String ans, int[][]show, int element){
        if( i == m -1 && j == n-1 )
        {

            System.out.println(ans);
            show[i][j] = element;
            for(int []b : show){
                System.out.println(Arrays.toString(b));
            }
            return 1;
        }
        if( i == m || j == n) return 0 ;
        if(check[i][j] == false) return 0;

        // move dwon
        check[i][j] = false;
        show[i][j] =element;
        int down= call(i+1, j , m,n,check, ans+"D",show,element+1);

        // movind left
        int left = call( i, j+1, m ,n,check,ans+"R",show,element+1);

        check[i][j] = true;
        show[i][j] = 0;
        return left + down;
    }
}
