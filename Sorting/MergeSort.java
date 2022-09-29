package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        System.out.println(" Here we do the problem On Merge sort: ");
        int []a = {2,6,9,3,2,7,4};
        int []ans = MergeSort1(a);
        System.out.println(" Before array is : " + Arrays.toString(a));
        System.out.println(" After array is : " + Arrays.toString(ans));
    }

    public static int[] MergeSort1(int[] a) {
        if(a.length==1)
            return a;
        int mid = a.length/2;
        int [] left = MergeSort1(Arrays.copyOfRange(a,0,mid));
        int [] right =MergeSort1(Arrays.copyOfRange(a,mid,a.length));

        return merge(left,right);
    }

    private static int[] merge(int[] a1, int[] a2) {
        int[] mix = new int[a1.length+a2.length];
      int i =0;
      int j=0;
      int k =0;
      while (i<a1.length && j<a2.length) {
          if (a1[i] < a2[j])
              mix[k++] = a1[i++];
          else
              mix[k++] = a2[j++];
      }
          while(i<a1.length)
          {
              mix[k++] = a1[i++];
          }
          while(j<a2.length)
          {
              mix[k++] = a2[j++];
          }

      return mix;

    }

}
