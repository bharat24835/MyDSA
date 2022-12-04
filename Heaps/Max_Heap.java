package Heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Max_Heap {
    public List<Integer> a ;

    public int count;

    public Max_Heap( ) {
        this.count=0;
        this.a=new ArrayList<>();
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
        return this.a.get(0);
    }

    public void display() throws Exception {
        if(this.count==0)
            throw new Exception("Erron is display program: ");
        System.out.println(a);
        System.out.println("");
    }

    private void swap( int i , int j){
        int temp = a.get(i);
        a.set(i ,a.get(j));
        a.set(j ,temp);
    }

    public void Max_Heapify(int i ){
        int left = 2*i +1;
        int right = 2*i +2;
        int largest = Integer.MIN_VALUE ;

        if(left < a.size() && this.a.get(left) > this.a.get(i)){
            largest = left;
        }
        else
            largest = i;
        if(right < a.size() && this.a.get(right) > a.get(largest))
            largest = right ;
        if(largest!=i){
            swap(i, largest );
            Max_Heapify(largest);
        }


    }

    public void Build_Heap(){
        for(int i = (this.a.size() -1)/2; i>=0 ; i--){
            Max_Heapify(i);
        }
    }

    public void insert(int value) throws Exception {

        this.count +=1;
        a.add(value);
        int i = count-1;
        // perlocate up algo

        while(i >0 && a.get(i/2) < a.get(i)){
            swap(i,i/2);
            i = i/2;
        }

    }

    public int extractMax() throws Exception {
        if(count <1){
            throw new Exception("Head underflow");
        }
        int max = a.get(0);
        //a[0] = a[count-1];
        a.set(0, a.get(a.size()-1));
        a.remove(a.size()-1);
        Max_Heapify(0);
        return max;
    }


}
