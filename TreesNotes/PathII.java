package TreesNotes;

import java.util.ArrayList;
import java.util.List;

public class PathII {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        root.right = new TreeNode(-3);
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(8);
//
//        root.left.left = new TreeNode(11);
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);
//
//        root.right.left = new TreeNode(13);
//        root.right.right = new TreeNode(4);
//        root.right.right.left = new TreeNode(5);
//        root.right.right.right = new TreeNode(1);

        System.out.println(pathSum(root, -5));

    }
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> outer = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();

        call( root, targetSum, inner, outer);
        //  if(outer.size() == 0)
        //  return 0;
        return outer;
    }
    public static void call( TreeNode root , int target, List<Integer> inner, List<List<Integer>> outer){


        if(root == null ){
            return;
        }
        inner.add(root.val);

        if(target == root.val && root.left==null && root.right == null ) {
            outer.add( inner);
            return;
        }

        int item = root.val;
        call(root.left, target-root.val,new ArrayList<>(inner ), outer);
        call(root.right,target-root.val, new ArrayList<>(inner ), outer);
        inner.remove(inner.size()-1);
    }
}
