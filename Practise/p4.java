package Practise;

import OOPs.A;

import java.util.ArrayList;

public class p4 {
    public static void main(String[] args) {
        ArrayList<Integer> inner = new ArrayList<>();
        ArrayList<ArrayList<Integer>> outer= new ArrayList<>();
        call(1,9, inner, outer);
        System.out.println(outer);
    }
    public static void call(int num , int target, ArrayList<Integer> inner,ArrayList<ArrayList<Integer>> outer  ){
        if(target == 0){
            outer.add(new ArrayList<>(inner));
            return;
        }
        if(num>10) return ;
        // take it function
        inner.add(num);
        call(num+1, target-num, inner, outer);

        inner.remove(inner.size()-1);
        call(num+1, target, inner, outer);
        return;
    }
}
