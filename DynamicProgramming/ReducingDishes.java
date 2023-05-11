package DynamicProgramming;

import java.util.Arrays;

public class ReducingDishes {
    public static void main(String[] args) {
        int []a = {-1,-8,0,5,-9};
        Arrays.sort(a);
        System.out.println(call(0,a,1));

    }
    public static int call(int i , int []a, int counter){
        if(i ==a.length) return 0;
        int takeit = a[i]*counter + call(i+1, a, counter+1);
        int ignoreit = 0 + call(i+1, a , counter);
        return Math.max(takeit, ignoreit);
    }
}
