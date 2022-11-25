package Bharat.Practsie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetArrayWithDuplicatesRecurssion {
    public static void main(String[] args) {
        int []nums = {1,2,3};
        System.out.println(subsetsWithDup( nums));

    }
//    public static List<List<Integer>> subsetsWithDup(int[] nums) {
//        Arrays.sort(nums);
//        List<List<Integer>> subsets = new ArrayList<>();
//        List<Integer> currentSubset = new ArrayList<>();
//
//        subsetsWithDupHelper(subsets, currentSubset, nums, 0);
//        return subsets;
//    }
//
//    private  static void subsetsWithDupHelper(List<List<Integer>> subsets, List<Integer> currentSubset, int[] nums, int index) {
//        // Add the subset formed so far to the subsets list.
//        subsets.add(new ArrayList<>(currentSubset));
//
//        for (int i = index; i < nums.length; i++) {
//            // If the current element is a duplicate, ignore.
//            if (i != index && nums[i] == nums[i - 1]) {
//                continue;
//            }
//            currentSubset.add(nums[i]);
//            subsetsWithDupHelper(subsets, currentSubset, nums, i + 1);
//            currentSubset.remove(currentSubset.size() - 1);
//        }
//    }
public static List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<Integer> subset = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    helper(nums,0,ans,subset);
    return ans;
}
    public static void helper(int[] nums, int index, List<List<Integer>> ans, List<Integer> subset)
    {

        if(index==nums.length)
        {
            ans.add(new ArrayList(subset));
            System.out.println(subset);
            return;
        }

        //take it :
        subset.add(nums[index]);
        helper(nums,index+1,ans,subset);

        //ignore it :
        while(index+1<nums.length && nums[index]==nums[index+1]){
            index++;
        }
        subset.remove(subset.size()-1);
        helper(nums,index+1,ans,subset);
    }
}
