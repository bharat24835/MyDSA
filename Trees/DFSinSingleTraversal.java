package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSinSingleTraversal {
    public static void main(String[] args) {
        Node4 q = new Node4(1);
        q.left=new Node4(2);
        q.right=new Node4(5);
        q.left.left=new Node4(3);
        q.left.right=new Node4(4);
        q.right.left=new Node4(6);
        q.right.right=new Node4(7);

        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(q,1));


        while(!st.empty()){
            Pair it = st.pop();


            if(it.num==1){
                // preorder
                preOrder.add(it.root.val);
                it.num++;
                st.push(it);
                if(it.root.left!=null){
                    st.push(new Pair(it.root.left,1));
                }
            }


            else if(it.num==2){
                // this is case of in order
                inOrder.add(it.root.val);
                it.num++;
                st.push(it);
                if(it.root.right!=null){
                    st.push(new Pair(it.root.right,1));
                }
            }
            else {
                // this is case of post order
                postOrder.add(it.root.val);

            }
        }
        System.out.println(" PreOrder :  " + preOrder);
        System.out.println(" InOrder :  " + inOrder);
        System.out.println(" PostOrder :  " + postOrder);
    }
}
class Pair{
    // we want pair(node , num);
    Node4 root;
    int num;

     Pair(Node4 q, int num) {
        this.root = q;
        this.num = num;
    }
}
class Node4{
    Node4 left;
    Node4 right;
    int val;

     Node4(int val) {
        this.val = val;
        this.left=null;
        this.right=null;
    }
}
