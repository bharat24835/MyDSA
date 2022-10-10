package Trees;

import java.util.*;

public class BottomBT {
    public static void main(String[] args) {
        TreeNode root= new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);

        root.right.right = new TreeNode(7);
        List<Integer> list = new ArrayList<>();

        list = call(root);
        System.out.println(list.toString());
    }
    public static List<Integer> call(TreeNode root ){
        TreeMap<Integer , TreeNode> map = new TreeMap<>();
        Queue<PairS> queue = new LinkedList<>();
        queue.offer(new PairS(root,0));
        List<Integer> list = new ArrayList<>();

        while(!queue.isEmpty()){
            PairS temp = queue.poll();
            int line = temp.line;
            TreeNode node = temp.root;

            if(!map.containsKey(line)) {
                map.put(line, node);
                //list.add(node.val);
            }

            if(node.left!=null)  queue.offer(new PairS(node.left,line-1));
            if(node.right!=null) queue.offer(new PairS(node.right, line+1));

        }

        for(Map.Entry<Integer,TreeNode> entry : map.entrySet()){
            TreeNode temp2  = entry.getValue();
            list.add(temp2.val);
        }

        return list;
    }
}
