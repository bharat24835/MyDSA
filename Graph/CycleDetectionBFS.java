package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionBFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adjListCreation(adj);
        int n = 7;
        boolean[]visited = new boolean[n+1];
        System.out.println("Here we wisht to Check out whether thsi Graph has cycle or not: " );
        System.out.println("Answer is : " + bfs(n,visited,adj));
    }

    public static boolean bfs(int n , boolean[]visited,ArrayList<ArrayList<Integer>> adj ){
        Queue<Pair> q = new LinkedList<>();
        // connect componet and where to start
        // here we are starting from (1,-1)
        // we suse condept (Node  , Parent)
        q.offer(new Pair(1,-1));
        visited[1]= true;

        while(!q.isEmpty()){

            Pair item = q.poll();
            int node = item.node;
            int parent = item.parent;

            for(int temp: adj.get(node)){
                if(visited[temp] == false){
                    visited[temp] = true;
                    q.offer(new Pair(temp,node));
                }
                else if(visited[temp] == true && temp != parent){
                    return true;
                }
            }

        }
        return false;
    }
    public static void adjListCreation(ArrayList<ArrayList<Integer> > adj ){
        // index 0 list
        adj.add(new ArrayList<>());

        // index 1 list
        adj.add(new ArrayList<>());
        adj.get(1).add(2);
        adj.get(1).add(3);

        // index 2 list
        adj.add(new ArrayList<>());
        adj.get(2).add(1);
        adj.get(2).add(5);

        // index 3 list
        adj.add(new ArrayList<>());
        adj.get(3).add(1);
        adj.get(3).add(4);
     //   adj.get(3).add(6);

        // index 4 list
        adj.add(new ArrayList<>());
        adj.get(4).add(3);

        // index 5 list
        adj.add(new ArrayList<>());
        adj.get(5).add(2);
        adj.get(5).add(7);

        // index 6 list
        adj.add(new ArrayList<>());
     //   adj.get(6).add(3);
        adj.get(6).add(7);

        // index 7 list
        adj.add(new ArrayList<>());
        adj.get(7).add(5);
        adj.get(7).add(6);
    }

}
class Pair{
    int node ;
    int parent ;
    Pair(int x , int y){
        this.node = x;
        this.parent = y;
    }
}
