package Trees.Solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConstructBSTFromPreOrder {
    public static void main(String[] args) {
        int []a = {8,5,1,7,10,12};
        int [] i = {0};
        System.out.println(" form Bst: "+  LS(call(a,Integer.MAX_VALUE,i)));

    }
//    public static TreeNode bstFromPreorder(int[] preorder) {
//        return call ( preorder ,Integer.MAX_VALUE, new int []{ 0});

//    }
    public static TreeNode call( int[] a  , int upperBound , int[] i)
    {
        // this i array is for pounter in array  a ;

        if( i[0] == a.length || a[i[0]]  > upperBound )
            return null;

        TreeNode root = new TreeNode (a[i[0]++]);
        root.left = call(a,root.val, i);
        root.right = call(a,upperBound , i );
        return root;
    }
    public static ArrayList<ArrayList<Integer>> LS(TreeNode root){
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();

        if(root==null)
            return output;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){

            List<Integer> list = new ArrayList<>();
            int size = queue.size();

            for (int i=0 ; i<size; i++){

                TreeNode temp = queue.poll();
                list.add(temp.val);

                if(temp.left!=null)  queue.add(temp.left);
                if(temp.right!=null) queue.add(temp.right);
            }
            output.add((ArrayList<Integer>) list);
        }
        return output;
    }
}
