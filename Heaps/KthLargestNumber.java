package Heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestNumber {
    public static void main(String[] args) {
        int[]a = {9,6,5,4,3,2,1};
        int k = 3;
        System.out.println("Arrays is : " + Arrays.toString(a));
        // this explanation is by Heap method
        System.out.println("Kth Largest Number is : " + call(a ,k));

        // this method is by Quick Selection Algo
        System.out.println("Kth Largest NUmber is : " + call2(a,k));
    }
    public static int call( int[]a , int k){
        // since we want k th largest element
        // an approach in which have a opposite property heap of size k
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int x : a){
            q.offer(x);
            if(q.size() > k)
                q.poll();
        }
        return q.peek();
    }

    public static int call2( int[]a , int k){
        int low = 0;
        int high = a.length-1;


        return  call5(low , high ,a,k) ;
    }

    public static int call5( int low, int high , int[]a, int k){
        while(low < high){
            int partion =  call3(low,high,a);
            if(a.length-1 - partion +1 == k)return a[partion];
            else if (a.length-1 - partion +1 > k) {
                return call5(partion+1,high,a,k);
            }
            else
                return call5(low,partion-1,a,k);
        }
        return 0 ;

    }

    public static int call3( int start, int end , int[]a){
        int mid = start + (end-start)/2;

         int pivit = a[mid];

        while(start < end){
            while(a[start] < pivit) start++;
            while(a[end] > pivit) end--;
           if(start<=end)
           {swap(start,end,a);
              start++;
            end--;}
        }
        System.out.println("Pivit Index is : " + mid);
        System.out.println("Pivit is : " + pivit);
        System.out.println(Arrays.toString(a));
        System.out.println("");
        return mid;
    }
    public static void swap( int i , int j , int[]a){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
