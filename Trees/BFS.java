package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        Node2 root = new Node2(1);
        root.left=new Node2(2);
        root.right= new Node2(3);

        root.left.left = new Node2(4);
        root.left.right = new Node2(5);

        root.right.left= new Node2(6);
        root.right.right= new Node2(7);

        System.out.println(LS(root));





    }
    public static ArrayList<ArrayList<Integer>> LS(Node2 root){
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();

        if(root==null)
            return output;

        Queue<Node2> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){

            List<Integer> list = new ArrayList<>();
            int size = queue.size();

            for (int i=0 ; i<size; i++){

                Node2 temp = queue.poll();
                list.add(temp.val);

                if(temp.left!=null)  queue.add(temp.left);
                if(temp.right!=null) queue.add(temp.right);
            }
            output.add((ArrayList<Integer>) list);
        }
        return output;
    }
}

     class Node2{
        int val;
        Node2 left;
        Node2 right;



         Node2(int val) {
            this.val = val;
            this.left=null;
            this.right=null;
        }
        Node2(Node2 root){
             this.val = root.val;
             this.left=null;
             this.right= null;
        }

         public Node2(int val, Node2 left, Node2 right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }



    }



