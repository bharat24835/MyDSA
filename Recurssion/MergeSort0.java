package New;

import java.util.Arrays;

public class MergeSort0 {
    public static void main(String[] args) {
        System.out.println("Here we wisht to solve inplace merge sort: ");
        int []a = {5,4,3,2};
        call(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
    public static void call( int[]a , int start , int end){
        if((end- start)==0)
            return;
         int mid = start + (end-start)/2;

         call(a,start,mid);
         call(a,mid+1,end);

         merge(a,start,mid+1,end);
         return;
    }
    public static void merge(int []a , int start, int mid, int end){

        int[]mix = new int[end-start+1];
        int i = start;
        int j= mid;
        int k = 0;
        while(i<mid && j<=end){
            if(a[i] < a[j])
                mix[k++]=a[i++];
            else
                mix[k++] = a[j++];
        }
        while(i<mid){
            mix[k++]=a[i++];
        }
        while(j<=end){
            mix[k++]=a[j++];
        }

        for (int l =0; l<mix.length; l++){
            a[start+l]=mix[l];
        }

    }
}
