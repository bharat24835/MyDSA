package Practise;

public class WinnerOfCircularGame {
    public static void main(String[] args) {
        int n = 6;
        int k=5;
        int ans = call(n,k);
        System.out.println(ans);
    }public static int call(int n, int k) {
        return helper(n, k) + 1;
        // we add +1 because of indexing problem ;
    }
    public static int helper( int n, int k){
        if(n==1)
            return 0;
        else{
            int x = helper(n-1,k); // search in lower order
            int y =  (x +k)%n;
            return y;
        }
    }
    }


