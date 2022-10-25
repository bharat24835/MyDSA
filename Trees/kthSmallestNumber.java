package Trees;

public class kthSmallestNumber {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        System.out.println(" FIndint the kth smalles interger " +kthSmallest(root, 6) );
    }
    public  static int kthSmallest(TreeNode root, int k) {

        // third parameter is for counter variable
        TreeNode node =  call( root, new int []{k});
        return node.val;
        // counter start with 1
    }
    public static TreeNode call( TreeNode root, int [] small ){

        if(root==null)
            return null  ;


        TreeNode left =  call(root.left, small );

        if(left!=null)
            return left;

        small[0]--;

        if(small[0] == 0 )
            return root;

        return call(root.right , small);





    }
}
