package Trees.Solution;




public class ConstructBSTPreOrder {
    public static   void main(String[] args) {
        int[] a = {8,5,1,7,10,12};

        TreeNode ans = bstFromPreorder(a);
        System.out.println(" the root of ELEMENT IS   : "   +  ans.val);
        System.out.println(ans.left.val);
        System.out.println(ans.right.val);




    }
    public   static  TreeNode bstFromPreorder(int[] preorder) {
        return call ( preorder ,Integer.MAX_VALUE, new int []{ 0});

    }
    public  static  TreeNode call(int[] a, int upperBound, int[] i)
    {
        // this i array is for pounter in array  a ;

        if( i[0] == a.length || a[i[0]]  > upperBound )
            return null;

        TreeNode root = new TreeNode (a[i[0]++]);
        root.left = call(a,root.val, i);
        root.right = call(a,upperBound , i );
        return root;
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


