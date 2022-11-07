package Trees;

import java.util.*;

public class VerticalOrder {
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
        System.out.println(" Now we are calling the key for vertical order traversal : ");
        System.out.println(call(root)) ;


    }
    public static List<List<Integer> > call( TreeNode root){
        TreeMap<Integer , Map<Integer, PriorityQueue<Integer>>> map  =  new TreeMap<>();
        Queue<Tuple> queue  = new LinkedList<>();
        queue.offer(new Tuple(root,0,0));

        while(!queue.isEmpty()){

            Tuple temp = queue.poll();
            TreeNode node  = temp.node;
            int y = temp.row;
            int x = temp.col;

            if(!map.containsKey(x))
                map.put( x, new TreeMap<>() );

            if(!map.get(x).containsKey(y))
                map.get(x).put(y,new PriorityQueue<>());

            map.get(x).get(y).offer(node.val);

            if(node.left!=null) queue.offer(new Tuple(node.left , x-1,y+1 ));
            if (node.right!=null) queue.offer(new Tuple(node.right, x+1, y+1));


        }


        List<List<Integer> > list = new ArrayList<>();

        for (Map<Integer, PriorityQueue<Integer>> ys : map.values() ) {

            list.add(new ArrayList<>());
            for ( PriorityQueue<Integer> nodes : ys.values() ) {
                while(!nodes.isEmpty()){
                    list.get(list.size()-1).add(nodes.poll());
                }

            }

        }
        return list;

    }

}
class Tuple{
    TreeNode node;
    int row;
    int col;

    public Tuple(TreeNode root, int col, int row) {
        this.node =root;
        this.row = row;
        this.col = col;
    }
}
