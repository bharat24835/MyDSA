package Bharat.Practsie;

public class CountStairs2 {
    public static void main(String[] args) {
        int n =5;
        System.out.println(" Number of distince ways to jump " + call( n));
    }
    public static int call( int n ){
        /*  1 1 1
            1 2
            2 1
        */
        int p1 = 1;
        int p2 = 1;
        int p3 = 1;

        for(int i = 2; i<3 ; i++){
            int temp = p1+p2;

          //  p3 = p2;
            p2 = p1;
            p1 = temp;
        }
        for(int i=3 ; i<=n; i++){
            int temp = p1+p2+p3;
            p3 = p2;
            p2 = p1;
            p1 = temp;

        }
        return p1;
    }
}
