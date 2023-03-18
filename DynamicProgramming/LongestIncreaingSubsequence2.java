package DynamicProgramming;

public class LongestIncreaingSubsequence2 {
    public static void main(String[] args) {
        int[]a = {7,4,5,1,8,12,4,7};
        int k = 5;
        int s =  call(0,-1,k,a);
        System.out.println("Anser we find is : "  +s);

    }
    public static int call(int i,int prev , int k , int []a){
        if(i ==a.length) return 0;

        int take = 0 ;
        if(prev == -1){
           // System.out.println("We have taken an element  : "  + a[i]);
            take = 1  + call(i+1,a[i], k, a);
        }else if(a[i] > prev && a[i] - prev <=3) {
         //   System.out.println("We have taken an lement : " +a[i]);
            take = 1 + call(i+1, a[i], k , a);
        }

        int ignore = 0 + call(i+1, prev, k, a);

        return Math.max (take , ignore);
    }
}
