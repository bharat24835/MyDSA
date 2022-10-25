package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryTraversal {
    public static void  main(String[] args) {
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

        System.out.println("Boundary traveral ANTICLOCKWISE : " + call(root));

    }

    public static List<Integer> call(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        addLeft(root, list);
        addLeaf(root, list);
        addRight(root, list);
        return list;
    }

    public static boolean ifLeaf(TreeNode root) {
        return (root.left == null && root.right == null);
    }

    public static void addLeft(TreeNode root, List<Integer> list) {

        TreeNode temp = root.left;
        while (temp != null) {
            if (ifLeaf(temp) == false)
                list.add(temp.val);
            if (temp.left != null)
                temp = temp.left;

            else
                temp = temp.right;
        }

    }

    public static void addLeaf(TreeNode root, List<Integer> list) {
        // this is preorder traversal
        TreeNode temp = root;
        if (ifLeaf(temp)) {
            list.add(temp.val);
        }
            if (temp.left != null) addLeaf(temp.left, list);
            if (temp.right != null) addLeaf(temp.right, list);

    }

    public static void addRight(TreeNode root, List<Integer> list) {
        TreeNode temp = root.right;
        Stack<Integer> st = new Stack<>();

        while (temp != null) {
            if(ifLeaf(temp) == false) st.add(temp.val);

            if(temp.right!=null) temp=temp.right;
            else temp = temp.left;

        }

        while(!st.isEmpty()){
            list.add(st.pop());
        }

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

