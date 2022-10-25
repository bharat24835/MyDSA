package com.company.Solution;

import java.util.Scanner;

public class kthSmallesInSortedArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" Here we wish to print the kth smallest number in sorted matrix : ");
        int [][]a = { {1,5,9},
                {10,11,13},
                {12,13,15}
        };
//        int [][] a = {{-5,-4},
//                {-5,-4}
//
//        };
        int k = 2;
         int ans = kthSmallest(a ,k );
        System.out.println(" Number is : " + ans);


    }
    public  static int kthSmallest(int[][] a, int k) {
        int n = a.length-1;
        int start = a[0][0];
        int end = a[n][n];

        while(start < end){

            int mid = start + (end - start )/2 ;

            int count  = lessEqual(a, mid);

            if(count < k){
                start = mid+1;

            }
            else
                end = mid;

        }
        return start;

    }
    // now we use top right OR bottom left approach in 2D array , row wise and column wise sorted array
    public  static int lessEqual( int[][]a, int target){
        int count = 0;
        int len = a.length;
        int i = len-1;
        int j = 0;
        // we are using bottom left approach

        while(i>=0 && j <len){
            if(a[i][j] > target){
                i--;
            }
            else{
                count = count + i +1;
                j++;
            }
        }
        return count;

    }

}
