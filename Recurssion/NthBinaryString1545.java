package LeetCodePractise;

import java.util.Arrays;

public class NthBinaryString1545 {
    public static void main(String[] args) {
        int n = 4;
        int k=15;
        char ans = findKthBit(n,k);
        System.out.println(ans);

    }
    public static char findKthBit(int n, int k) {
        if(n==1 && k==1)
            return '0';
        int size = (int)Math.pow(2,n)-1;
        int mid = ((int)Math.pow(2,n)-1)/2+1;
        if(k==mid)
               return '1';
        if(k<mid)
            return findKthBit(n-1,k);
        else
        {
            if(findKthBit(n-1,size-k+1)=='0')
                return '1';
            else return '0';
        }

    }
}
