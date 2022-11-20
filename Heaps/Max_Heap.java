package Heaps;

import java.util.Arrays;

public class Max_Heap {
    public  int[]a;
    public int capacity;
    public int count;

    public Max_Heap(int capacity) {
        this.capacity = capacity;
        this.count=0;
        this.a=new int[capacity];
    }

    public int Parent( int i ) throws Exception {
        if(i<=0 || i>=this.count)
            throw  new Exception("Error hai bhai , please dekho ussmai: ");

        return (int)i/2;
    }

    public int LeftChild( int i ) throws Exception {
        int left = 2*i + 1;
        if(left>=this.count)
            throw new Exception(" Error in left child program :  ");

        return left;
    }

    public  int RightChild ( int i ) throws Exception {
        int right = 2*i +2;
        if(right>=this.count)
            throw new Exception(" Error in Right child program:  ");
        return right;
    }

    public int GetMax( ) throws Exception {
        if(this.count==0)
            throw new Exception("Error in get max progarma; ");
        return this.a[0];
    }

    public void display() throws Exception {
        if(this.count==0)
            throw new Exception("Erron is display program: ");
        System.out.println(Arrays.toString(this.a));
    }

    private void swap(int[]a, int i , int j){
        int temp = a[i];
        a[i] =a[j];
        a[j] = temp;
    }

    public void Max_Heapify(int i ){
        int left = 2*i +1;
        int right = 2*i +2;
        int largest = Integer.MIN_VALUE ;

        if(left < this.capacity && this.a[left] > this.a[i]){
            largest = left;
        }
        else
            largest = i;
        if(right < this.capacity && this.a[right] > a[largest])
            largest = right ;
        if(largest!=i){
            swap(this.a ,i, largest );
            Max_Heapify(largest);
        }


    }

    public void Build_Heap(){
        for(int i = (this.capacity -1)/2; i>=0 ; i--){
            Max_Heapify(i);
        }
    }

    public void insert(int value) throws Exception {
        if(count == capacity){
            throw new Exception(" Error in insert program: " );

        }
        this.count +=1;
        a[count-1] = value;
        int i = count-1;
        // perlocate up algo

        while(i >0 && a[i/2] < a[i]){
            swap(a,i,i/2);
            i = i/2;
        }

    }


}
