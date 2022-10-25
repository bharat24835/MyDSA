package com.company;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int []a = {1,8,6,2,5,4,8,3,7};
        System.out.println(" Most water is : " + call(a));
    }
    public static int call(int []a ){
        int max = Integer.MIN_VALUE;

        int i =0  ;
        int j = a.length-1;

        while( i < j){
            int cur = (j-i)*Math.min(a[i] , a[j]);

            if(a[i] < a[j]){
                i++;

            }
            else j--;
            max = Math.max(max,cur);
        }
        return max;

    }
}
