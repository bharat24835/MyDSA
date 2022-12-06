package DynamicProgramming;

public class CountStairs {
    public static void main(String[] args) {
        int n = 4;
        // you can skip 1 , 2 jump steps at a time
        // count nummber of ways to reach n stairs
        System.out.println("Answer by Recurssion : "  + call1(n));
        System.out.println("Answer by Tabulation : "  + call2(n));
        System.out.println("Answer by Space Optimization : "  + call3(n));
    }
    public static  int call1( int n){
        if(n==0)return 1;
        if(n<0)return 0;
        return call1(n-1)+call1(n-2);
    }
    public  static int call2( int n){
        int [] dp = new int[n+1];
        dp[0] = 1; // jab hum sirf 1 steps jump karenge
        dp[1] = 1; // jab hum sirf 2 steps jump karegge

        for( int i =2; i<=n ; i++){
            dp[i] = dp[i-1]+ dp[i-2];

        }
        return dp[n];

    }

    public static  int call3( int n ){
        int p1 = 1;
        int p2 = 1;
        for( int i =2; i<=n ; i++){
            int temp = p1+p2;
            p2 = p1;
            p1 = temp;
        }
        return p1;
    }
}
