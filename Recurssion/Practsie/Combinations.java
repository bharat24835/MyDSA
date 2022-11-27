package Bharat.Practsie;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        int n = 4;
        int k =2;
        System.out.println(combine(n,k));
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>  outer = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();

        call( n, k, outer, inner,1);
        return outer;

    }
    public static void call( int n , int k , List<List<Integer>> outer, List<Integer> inner,int i){

        if(n+2==i)
            return;
        if(k == inner.size()){
            outer.add(inner);
            return;
        }

        // take it
        inner.add(i);
        call( n, k , outer, new ArrayList<>(inner), i+1);

        //ignore it
        inner.remove(inner.size()-1);
        call(n, k , outer, new ArrayList<>(inner), i+1);
    }
}
