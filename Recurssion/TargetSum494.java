package LeetCodePractise;

import java.util.Scanner;

public class TargetSum494 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.println(" Here we wish to print the number of ways that that array can reorder so that we get sum target: ");
        int []a = {1,1,1,1,1};
        int target = 3;
        int ways= findTargetSumWays(a,target);
        System.out.println(ways);


    }
    public static int findTargetSumWays(int[] a, int target) {
        int pos = 0; // for index for array
        int count =0;
        int ans = call(a,target, pos, count);
        return ans;
    }
    public  static int call(int[]a , int target, int pstart, int count)
    {
        if(target==0 && pstart==a.length)
            return 1;
        if(pstart ==a.length)
            return 0;

        // there are only two operation that are going here
        return (call(a,target+a[pstart], pstart +1,count)+ call(a,target-a[pstart], pstart +1,count));
    }
}
