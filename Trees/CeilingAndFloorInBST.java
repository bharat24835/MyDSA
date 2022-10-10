package Trees;

public class CeilingAndFloorInBST {
    public static void main(String[] args) {
        TreeNode root= new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(13);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);

        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(4);


       // root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(9);

        root.right.right = new TreeNode(14);
        root.right.left = new TreeNode(11);


        int target = 12;
         ceiling( root,target);
       // TreeNode f = floor(TreeNode root);
        //System.out.println(" Ceiling of target : " + c);

    }
    public static  void ceiling( TreeNode root,int target){

        int cling = -1;
        int flor = -1;

        while(root!=null) {
            if(root.val== target){
                cling= flor= root.val;
            }
            if(root.val <  target){
                flor = root.val;
                root = root.right;
            }
            else {
                cling = root.val;
                root = root.left;

            }

        }
        System.out.println(" Floor of target is :  " + flor);
        System.out.println(" Ceiling of target is  : " + cling);


    }
}
