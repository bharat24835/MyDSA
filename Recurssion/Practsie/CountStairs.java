package Bharat.Practsie;

public class CountStairs {
    public static void main(String[] args) {
        int n =5;
        // let us assume we can skip 1,2,3 steps at a time

        /* 1 1 1 1
           1 1 2
           1 2 1
           2 1 1
           2 2
           1 3
           3 1
         */

        int ans = call(n);
        System.out.println(" Number of distict ways to jump : "+ ans) ;

    }
    public static int call( int n){
       if(n==0)return 1;
       if(n<0) return 0;

       int jump1 = call(n-1);
       int jump2 = call(n-2);
       int jump3 = call(n-3);
       return jump1+jump2+jump3;
    }
}
