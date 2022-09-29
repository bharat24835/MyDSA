package RecurssionGFG;

import java.util.ArrayList;

public class NDigitNumberInIncreasingOrder {
    public static void main(String[] args) {
        int n=2;
        ArrayList<Integer> ans = new ArrayList<>();
        call2(n,ans, 0);
        System.out.println(ans);
    }
    public static void call2( int n, ArrayList<Integer> ans, int rem){
        if(n<1){
            ans.add(rem);
            return ;
        }

        for( int i =0 ; i<=9  ; i++){
          if(i>rem%10){
              rem=rem*10+i;
              call2(n-1,ans,rem);
              rem=rem/10;
          }
        }

    }
}
