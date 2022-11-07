package Trees.MadeEasy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RootToLeafP23 {
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
        System.out.println(" Printing all the path from root to leaf:  that can be possibel using recursision : ");
       Print(root, new int[100], 0);

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
    public static void Print(TreeNode root, int[]p , int len){
        if(root==null){

            return;
        }
        p[len] = root.val;
        len++;

        if(root.left==null && root.right==null){
            p(root,p,len);
        }
        else{
            Print(root.left,p,len);
            Print(root.right,p,len);
        }





    }
    public static void p (TreeNode root, int [] p , int len){
      for(int i = 0 ; i<len ; i++){
          System.out.print(p[i]);
      }
        System.out.println("");
        return;
    }

}
