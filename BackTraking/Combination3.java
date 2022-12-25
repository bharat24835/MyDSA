package LeetCodePractise;

import java.util.ArrayList;
import java.util.List;

public class Combination3 {
    public static void main(String[] args) {
        int nElement = 9 ;
        int sum = 45;
        List<Integer> inner = new ArrayList<>();
        List<List<Integer>> outer = new ArrayList<>();
        call( 1, nElement, sum , inner, outer);
        System.out.println(outer);
    }

    public static void  call( int element , int nElemnt, int sum, List<Integer> inner, List<List<Integer>> outer){


        if(nElemnt <=0 && sum != 0){
            return;
        }
        if(sum < 0)return;

        if(nElemnt == 0 && sum ==0){
            outer.add(new ArrayList<>(inner));
            return;
        }
        if(element > 9 )return;

        // taek it
        inner.add( element);
        call(element+1, nElemnt-1, sum -element, inner, outer);

        // ignlre it
        inner.remove(inner.size() - 1);
        call(element+1, nElemnt, sum , inner, outer);



    }
}
