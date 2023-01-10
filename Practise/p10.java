package Practise;

import java.util.Arrays;

public class p10 {
    public static void main(String[] args) {
        int [] price = {1,2,3};
        int []q = {3,2,1,5};
        int[]ans = new int[q.length];

        for(int  i  = 0 ; i<q.length ; i++){
            int diff = 0;
            for(int j = 0 ; j<price.length; j++){
                diff+=Math.abs(price[j]-q[i]);
            }
            ans[i] = diff;
        }

        System.out.println(Arrays.toString(ans));
    }
}
