package LeetCodePractise;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[]a = {2,3,6,7};
        int target=7;
        System.out.println("Ans is: ");
        System.out.println(combinationSum(a,target));
     //   Output: [[2,2,3],[7]]
    }
    public  static List<List<Integer>> combinationSum(int[] a, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(a,0,target,new ArrayList<Integer>(), result);
        return result;
    }
    public static  void backtrack( int[]a, int start ,int target, List<Integer> list , List<List<Integer>> ans)
    {
        if(target <0)
            return;
        if(target==0)
        {
            ans.add(new ArrayList(list));

        }
        for (int i = start; i < a.length; i++) {
            list.add(a[i]);
            backtrack(a,i, target-a[i], list,ans);
            list.remove(list.size()-1);
        }

    }

}
