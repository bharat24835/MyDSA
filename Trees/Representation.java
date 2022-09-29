package Trees;

public class Representation {
    public static void main(String[] args) {
        Node a1 = new Node(1);
        Node a2 = new Node(2);
        Node a3 = new Node(3);
        Node a4 = new Node(4);
        Node a5 = new Node(5);
        Node a6 = new Node(6);
        Node a7 = new Node(7);
        Node a8 = new Node(8);
        Node a9 = new Node(9);
        Node a10 = new Node(10);

        a1.left=a2;
        a1.right=a3;

        a2.left =a4;
        a2.right=a5;

        a3.left=a6;
        a3.right=a7;

        a5.left=a8;

        a7.left=a9;
        a7.right=a10;

        System.out.println("Here we are performing preorder traversal : ");
        a1.preOrderTrav(a1);

        System.out.println("");
        System.out.println("here we are forming Inorder traversal  : " );

        a1.inOrderTrav(a1);

        System.out.println("");
        System.out.println(" Here we wish to perform PostOrder traversal : ");

        a1.postOrderTrav(a1);




    }
}

   class Node{
    int val;

    Node left;
    Node right;
    Node(int key){
        this.val = key;
        this.left=null;
        this.right=null;
    }

    public void preOrderTrav(Node curNode){

        if(curNode==null)
            return;
        System.out.print(curNode.val+ " " );
        preOrderTrav(curNode.left);
        preOrderTrav(curNode.right);
    }
    public void inOrderTrav(Node curNode){

        if(curNode==null)
            return;
        inOrderTrav(curNode.left);
        System.out.print(curNode.val + " ");
        inOrderTrav(curNode.right);
    }

    public void postOrderTrav(Node curNode){

        if(curNode==null)
            return;
        inOrderTrav(curNode.left);

        inOrderTrav(curNode.right);

        System.out.print(curNode.val + " ");
    }
}
