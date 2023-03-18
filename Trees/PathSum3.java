package Trees;

import java.util.ArrayList;
import java.util.Arrays;

public class PathSum3 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(10);
        t1.left = new TreeNode( 5);
        t1.right = new TreeNode(-3);

        t1.left.left = new TreeNode(3);
        t1.left.right  = new TreeNode(2);

        t1.left.left.left = new TreeNode(3);
        t1.left.left.right = new TreeNode(-2);

        t1.left.right.right = new TreeNode(1);

        t1.right.right  = new TreeNode(11);
        int target = 8;
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        System.out.println("Number of rows: "  +call(t1,target,outer,new ArrayList<>(),   0));
        System.out.println(outer);
    }
    public static int call(TreeNode root, int target,ArrayList<ArrayList<Integer>> outer, ArrayList<Integer> inner, int flag ){
        if(root == null )return 0;

        if( target == root.val){
            System.out.println("We found the elment at : " + root.val);
            inner.add(root.val);
            outer.add(new ArrayList<>(inner));
            inner.remove(inner.size()-1);
            return 1;
        }
        // if(target < root.val)return 0;
        // ignore it
        int igleft = 0;
        int igright = 0;
        if(flag == 0){
         igleft = call(root.left, target,outer,inner,0);
         igright = call(root.right, target,outer,inner,0);
        }

        // take it
        inner.add(root.val);
        int left = call(root.left, target-root.val,outer, inner,1);
        int right = call(root.right, target-root.val,outer, inner,1);
        inner.remove(inner.size()-1);

        // return take it + ignore it
        return left + right + igleft + igright;
    }
}
