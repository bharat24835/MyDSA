package TreesNotes;


import com.sun.source.tree.Tree;

public class TreeNode {

        int val;
       TreeNode  left;
        TreeNode right;



        TreeNode(int val) {
            this.val = val;
            this.left=null;
            this.right=null;
        }
        TreeNode(TreeNode root){
            this.val = root.val;
            this.left=null;
            this.right= null;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }



    }

