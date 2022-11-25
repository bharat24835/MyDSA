package Bharat.Practsie;

import java.util.ArrayList;
import java.util.List;

public class PerMutationRecurssion {
    public static void main(String[] args) {
        List<List<Integer>>outer = new ArrayList<>();
        List<Integer> inner  = new ArrayList<>();

        int []a = {1,2,3};
        call(outer, inner, a, 0);
        System.out.println(outer);
    }
    public static void call( List<List<Integer>> outer, List<Integer> inner , int[]a , int index){

        if(index==a.length){
            outer.add(inner);
//            System.out.println(" Inner is :   "+inner);
//            System.out.println("Outer is :  "+outer);
            return;
        }

        for(int i=0; i<=inner.size(); i++){
            // before
            inner.add(i,a[index]);
            call(outer, new ArrayList<>(inner), a, index+1);
            inner.remove(i);

        }
        return;



    }
}
