package Bharat.Practsie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        int []a ={2,5,2,1,2};
        int target = 5;
        System.out.println(combinationSum2(a,target));

    }
    public static List<List<Integer>> combinationSum2(int[] a, int target) {
        Arrays.sort(a);
        List<List<Integer>> outer = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        call( a, target ,inner, outer , 0);
        return outer;
    }
    public static void call( int[]a , int target, List<Integer> inner, List<List<Integer>> outer,int index){

        if(target == 0){
            outer.add(new ArrayList<>(inner));
            return;
        }
        if(index == a.length || target < 0 )return ;

        // take it
//        sum+=a[index];
        inner.add(a[index]);
        call(a,target -a[index]  , inner, outer, index+1);

        // ignoring it
//        sum-=a[index];
        inner.remove(inner.size() -1);
        while(index+1 < a.length  && a[index] == a[index+1]){
            index++;
        }

        call( a,target , inner, outer, index+1);


    }
}
