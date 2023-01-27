package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipatiteBFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        createadj(adj);

        int []color = new int[9];
        Arrays.fill(color,-1);
        // -1 means not colorued;

        System.out.println("Graph is Bipatite : " + bfs(color,adj));
        //
    }

    public static boolean bfs(int[]color,  ArrayList<ArrayList<Integer>> adj ){
        Queue<Integer> q= new LinkedList<>();
        q.offer(1);
        color[1]= 1;

        while(!q.isEmpty()){
            int node = q.poll();
            int c= color[node];
            for(int temp : adj.get(node)){

                if(color[temp] != -1){
                    if(color[temp] == c)
                        return false;
                }else {
                    color[temp ] = (c+1)%2;
                    q.offer(temp);
                }
            }
        }
        return true;
    }
    public static void createadj( ArrayList<ArrayList<Integer>> adj ){
        // indexing 0
        adj.add(new ArrayList<>());

        // indexing 1
        adj.add(new ArrayList<>());
        adj.get(1).add(2);

        // indexing 2
        adj.add(new ArrayList<>());
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(2).add(6);

        // indexing 3
        adj.add(new ArrayList<>());
        adj.get(3).add(2);
        adj.get(3).add(4);

        // indexing 4
        adj.add(new ArrayList<>());
        adj.get(4).add(3);
        adj.get(4).add(5);
        adj.get(4).add(7);

        // indexing 5
        adj.add(new ArrayList<>());
        adj.get(5).add(4);
        adj.get(5).add(6);

        // indexing 6
        adj.add(new ArrayList<>());
        adj.get(6).add(2);
        adj.get(6).add(5);

        // indexing 7
        adj.add(new ArrayList<>());
        adj.get(7).add(4);
        adj.get(7).add(8);

        // indexing 8
        adj.add(new ArrayList<>());
        adj.get(8).add(7);
    }
}
