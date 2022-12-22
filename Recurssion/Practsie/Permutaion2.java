package Bharat.Practsie;

import java.util.ArrayList;
import java.util.List;

public class Permutaion2 {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        List<Integer> inner = new ArrayList<>();
        List<List<Integer>> outer = new ArrayList<>();
        boolean []check = new boolean[a.length];
        call( a, inner, outer , check);
    }
    public static void  call (  int[]a , List<Integer> inner, List<List<Integer>> outer, boolean[]check){
        if(inner.size() == a.length){
            outer.add(new ArrayList<>(inner));
            return;
        }

        for( int i = 0 ; i<a.length; i++){
            if(!check[i]){
                check[i] = true;
                inner.add(a[i]);
                call(a, inner, outer, check);

            }
        }
    }
}
