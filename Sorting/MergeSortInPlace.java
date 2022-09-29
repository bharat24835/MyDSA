package Bharat;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSortInPlace {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        System.out.println(" Here we goona do the inplace merge sort: " );
        int []a  = { 9,6,4,1};
       int b =  mergesort(a,0,a.length);
        System.out.println(" Array after the sorting is : "+ Arrays.toString(a));

    }

     static int mergesort(int[] a, int s, int e) {

        if((e-s)==1)
            return 0 ;
        int m = (s+e)/2;
        mergesort(a,s,m);
        mergesort(a,m,a.length);
     int c =   merge(a,s,m,e);
        return 0;
    }
    public static int merge(int[]a ,int s, int m, int e)
    {
        int []mix = new int[e-s];
        int i =s;
        int j =m;
        int k =0;
        while(i<m && j<e )
        {
            if (a[i] < a[j] )
                mix[k++] = a[i++];
            else mix[k++] = a[j++];
        }
        while(i<m)
        {
            mix[k++] = a[i++];

        }
        while (j<e){
            mix[k++] = a[j++];
        }
        for (int l =0 ;l<mix.length; l++ )
        {
            a[s+l]= mix[l];
        }
        return 0;
    }
}
