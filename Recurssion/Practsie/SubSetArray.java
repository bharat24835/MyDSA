package Bharat.Practsie;

import java.util.ArrayList;
import java.util.List;

public class SubSetArray {
    public static void main(String[] args) {
        int []a = {1,2,3};
        List<List<Integer>> outer = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        call(outer, inner , a , 0);
        System.out.println(outer);
    }
    public static void call(List<List<Integer>> outer, List<Integer> inner , int[]a , int index){

        if(index== a.length){
            outer.add(inner);
            System.out.println(inner);
            return;
        }


        // take it
        inner.add(a[index]);
        call(outer, new ArrayList<>(inner), a, index+1);


        //ignore it
        inner.remove(inner.size()-1);
        call(outer, new ArrayList<>(inner), a , index+1);
    }
}
