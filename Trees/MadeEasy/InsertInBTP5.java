package Trees.MadeEasy;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InsertInBTP5 {
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

        System.out.println(" Before adding  : " + LS(root));

        System.out.println(" Insert the node  "  +  call(root,12 ));

        System.out.println(" Level order traversal : "  + LS(root));
    }
//    public  static void call(TreeNode root, int val){
//      if(root.left!=null)
//          call(root.left,val);
//      else
//          root.left = new TreeNode(val);
//      if(root.right != null)
//          call(root.right, val);
//      else
//          root.right = new TreeNode(val);
//
//
//
//    }
    // look it is difficult to inset an elkemetn in binary tree usign recurssion:

    public static int call(TreeNode root, int element){

        if(root==null)
            root= new TreeNode(element);
        Queue<TreeNode> q  = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){


            int size = q.size();

            for(int i = 0 ; i<size ; i++){
                TreeNode temp = q.poll();




                if(temp.left!=null)
                    q.offer(temp.left);
                else{
                    temp.left = new TreeNode(element);
                    return element;
                }
                if(temp.right!=null) q.offer(temp.right);
                else {
                    temp.right = new TreeNode(element);
                    return element;
                }

            }
        }
        return 0;

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

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
