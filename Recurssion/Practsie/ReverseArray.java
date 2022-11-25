package Bharat.Practsie;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int []a = {1,2,3,4,5,6,7,8};
        int left =  2;
        int right = 6;

        call( a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }
    public static void  call( int []a , int left, int right){

        if(left>= right)
        return;
        if(left>=2 && right<=6)
        {
            int temp = a[left];
            a[left]= a[right];
            a[right]  = temp;
        }

        call(a, left+1, right-1);
    }
}
