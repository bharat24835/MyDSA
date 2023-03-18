package DynamicProgramming;

public class BuyAndSellStock3 {
    public static void main(String[] args) {
        int[]a = {3,3,5,0,0,3,1,4};
        System.out.println(" We can only buy and sell at max : 2 times ");
        int k = 2;
        System.out.println(" Max Profit is : " + call(0,1,k,a));
    }
    public static int call(int i , int buy , int k, int[]a){
        if(k == 0)return 0;
        if(i == a.length) return 0;
        int profit = 0;
        if(buy == 1){
            profit  = Math.max(-a[i] + call(i+1,0,k,a), 0 + call(i+1, 1, k, a) );
        }
        else{
            profit = Math.max(a[i] + call(i+1, 1, k-1,a) ,  0+ call(i+1, 0, k, a));
        }
        return  profit;
    }
}
