package MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {
    public static void main(String[] args) {
        int[]a= {73,74,75,71,69,72,76,73};
        System.out.println(" Answer by Recurssion" + Arrays.toString(call(a))); // TC=O(n*n), SC= O(N)
        System.out.println(" Answer by Stack " + Arrays.toString(call2(a)));  // TC= O(N) SC = O(N)
        System.out.println(" Answer by Jumping " + Arrays.toString(call3(a))); // TC=O(N) SC= O(1)
    }
    public static int[] call( int[]a){
        int[]ans = new int[a.length];
        for (int i = 0 ; i<a.length; i++){
            int count  = 0;
            for (int j = i; j<a.length; j++){
                if(a[i] < a[j]){
                    count  = j-i;
                    break;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
    public static int[]call2(int[]a){
        int[]ans = new int[a.length];
        int n  = a.length;
        Stack<Integer> st = new Stack<>();

        for( int i = n-1; i>=0 ; i--){
            if(st.isEmpty()){
                st.push(i);
                ans[i] = 0;
            }
            else{
                while( !st.isEmpty() && a[i] >= a[st.peek()]){
                    st.pop();
                }
                if(st.isEmpty()) ans[i] = 0;
                else {
                    ans[i] = st.peek() - i;

                }
                st.push(i);

            }
        }
        return ans;
    }
    public static int[]call3(int[]a){
        int n = a.length;
        int hottest = Integer.MIN_VALUE;
        int[]ans = new int[n];
        Arrays.fill(ans,0);

        for(int i = n-1; i>=0 ; i--){

            if(a[i]  >= hottest ){
                hottest = a[i];
            }
            else {
                int it = i+1;

                while(a[it] <= a[i]){
                    it = it + ans[it];
                }
                ans[i] = it-i;
            }
        }
        return  ans;

    }
}
