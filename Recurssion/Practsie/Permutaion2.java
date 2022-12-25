package Bharat.Practsie;

import java.util.ArrayList;
import java.util.List;

public class Permutaion2 {
    public static void main(String[] args) {
        int[] a = {1,2,2};
        List<Integer> inner = new ArrayList<>();
        List<List<Integer>> outer = new ArrayList<>();
        boolean []check = new boolean[a.length];
        call( a, inner, outer , check);
        System.out.println(outer);
    }
    public static void  call (  int[]a , List<Integer> inner, List<List<Integer>> outer, boolean[]check){
        if(inner.size() == a.length){
            outer.add(new ArrayList<>(inner));
            return;
        }

        for( int i = 0 ; i<a.length; i++){
            if(i>0 && a[i-1]==a[i] && !check[i-1]) continue;
            if(!check[i]){
                check[i] = true;
                inner.add(a[i]);
                call(a, inner, outer, check);
                inner.remove(inner.size()-1);
                check[i] =false;

            }
        }
    }
}
