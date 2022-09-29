package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class IterativeDFS {
    public static void main(String[] args) {
        Node3 q = new Node3(1);
        q.left=new Node3(2);
        q.right=new Node3(7);
        q.left.left=new Node3(3);
        q.left.right=new Node3(4);
        q.left.right.left= new Node3(5);
        q.left.right.right= new Node3(6);
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder1 = new ArrayList<>();
        List<Integer> postOrder2 = new ArrayList<>();
        preOrder  = itPreOrder(q);
        System.out.println(" PRINTING PREORDER TRAVERSAL ITERATIVE WAY : ");
        System.out.println(preOrder);
        postOrder1 = itPostOrder1(q);
        System.out.println(" PRINTING  POSRTORDER TRAVERSAL ITERATIVE WAY : Using 2 stack  : ");
        System.out.println(postOrder1);

        postOrder2 = itPostOrder2(q);
        System.out.println(" PRINTING POSRTORDER TRAVERSAL ITERATIVE WAY :  Using 1 stack : ");
        System.out.println(postOrder2);

        inOrder = itInOrder(q);
        System.out.println(" Printign INorder traversak in iterative ways   : ");
        System.out.println(inOrder);

        System.out.println(" The height of This tree is : " + height(q));



    }

    public static int height(Node3 root){

        if(root == null)
            return 0;
        int left = height(root.left);
        int right = height(root.right);

        return 1 + Math.max(left,right);

    }


    public static List<Integer> itPreOrder(Node3 root){
        Stack<Node3> st = new Stack<>();
        List<Integer> list  = new ArrayList<>();
        if(root==null)
            return list;
        st.push(root);

        while(!st.isEmpty()){

            Node3 temp = st.pop();
            list.add(temp.val);
            if(temp.right!=null) st.push(temp.right);
            if(temp.left!=null) st.push(temp.left);

        }
        return list;


    }

    public static List<Integer> itInOrder(Node3 root){
        Stack <Node3> st = new Stack<>();
        List<Integer> list = new ArrayList<>();

        if(root==null)
            return list;

        while(true){

            if(root!=null){
                st.push(root);
                root=root.left;
            }
            else {
                if (st.isEmpty())
                    break;
                root =st.pop();
                list.add(root.val);
                root=root.right;


            }
        }
        return list;

    }

    public static List<Integer> itPostOrder1(Node3 root){
        // here we are itereing it using 2 stack
        Stack<Node3> st1 = new Stack<>();
        Stack<Node3> st2 = new Stack<>();
        List<Integer> list = new ArrayList<>();

        st1.push(root);
        if (root==null){
            return list;
        }

        while(!st1.isEmpty()){
            Node3 temp = st1.pop();
            st2.push(temp);
            if(temp.left!=null) st1.push(temp.left);
            if(temp.right!=null) st1.push(temp.right);

        }

        while(!st2.isEmpty()){
            list.add(st2.pop().val);
        }
        return list;
    }

    public static List<Integer> itPostOrder2(Node3 root){
        List<Integer> list = new ArrayList<>();
        Stack <Node3> st = new Stack<>();
        // using single stack
        // normally known as go left left null go right go left null null then root

        while(root!=null  ||  !st.isEmpty()){
            if(root!=null){
                st.push(root);
                root=root.left;
            }
            else{
                // measn root.left is null:

                Node3 temp = st.peek().right;

                if(temp==null){ // go back situtaion

                    temp= st.pop();
                    list.add(temp.val);

                    while(!st.empty() && temp== st.peek().right){
                        temp = st.pop();
                        list.add(temp.val);

                    }


                }
                else
                    root=temp;


            }


        }


        return list;
    }
}

class Node3{
    int val;
    Node3 left;
    Node3 right;

     Node3(int val) {
        this.val = val;
        this.left=null;
        this.right=null;
    }
}