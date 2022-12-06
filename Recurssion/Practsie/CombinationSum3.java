package Bharat.Practsie;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public static void main(String[] args) {
        int k = 4 ;
        int n =     1;
        List<List<Integer>> outer =  new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        call( k ,n ,inner, outer,1,0);
        System.out.println(outer);
    }
    public static void call(int k , int n , List<Integer> inner, List<List<Integer>> outer, int num, int sum){

        if(num > n ) return ;
        if(inner.size() > k) return;


        if(inner.size() == k ){
            if(sum==n){
                outer.add(new ArrayList<>(inner));
                return;
            }
            else
                return;
        }

        // take it
        inner.add(num);
        call(k , n, inner, outer, num+1 , sum+num);

        //ignore it
        inner.remove(inner.size() - 1);
        call( k , n, inner, outer,num+1 , sum);
    }
}
