package Trees.MadeEasy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DiameterBTP21 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);


        root.left.left.right = new TreeNode(4);
        root.left.left.right.left = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);

        root.right = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.right.left.left = new TreeNode(10);
        root.right.right.left.right = new TreeNode(11);
        System.out.println(LS(root));
        System.out.println(" Width of trees is  : " + width(root) );


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

    public  static  int width(TreeNode root){
        int max = 0 ;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            int count =0;

            for(int i = 0; i<size; i++){
                TreeNode temp = q.poll();
                count++;
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);

            }
            max = Math.max(max, count);

        }
        return max;
    }
}
