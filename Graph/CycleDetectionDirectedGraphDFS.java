package Graph;

import java.util.ArrayList;

public class CycleDetectionDirectedGraphDFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj  = new ArrayList<>();
        System.out.println("Here wish to detect cycle in Directed Graph: ");
        createList(adj);
        int[]visited = new int[adj.size()];
        int[]pathvisted = new int[adj.size()];
        // 0 for unvisitd and 1 for visited
        // connect componet / start condition
        for(int i = 1 ; i<adj.size(); i++) {
            if (visited[i] == 0) {
                if (dfs(i, visited, pathvisted, adj) == true) {
                    System.out.println("Found Cycle : ");
                    break;

                }
            }
        }
    }

    public static boolean dfs(int element , int[]visited, int[]pathvisited, ArrayList<ArrayList<Integer>> adj ){
        visited[element] = 1;
        pathvisited[element] = 1;

        for(int temp : adj.get(element)){
            if(visited[temp] == 0)
            {
                if(dfs(temp,visited,pathvisited,adj) == true)
                    return true;
            }
            else  if(visited[temp] == 1 && pathvisited[temp] == 1){
                return true;
            }

        }
        // backtracking
        pathvisited[element] = 0;
        return false;
    }
    public static void createList( ArrayList<ArrayList<Integer>> adj) {
        // index 0
        adj.add(new ArrayList<>());

        // index 1
        adj.add(new ArrayList<>());
        adj.get(1).add(2);

        // index 2
        adj.add(new ArrayList<>());
        adj.get(2).add(3);

        // index 3
        adj.add(new ArrayList<>());
        adj.get(3).add(4);
        adj.get(3).add(7);

        // index 4
        adj.add(new ArrayList<>());
        adj.get(4).add(5);

        // index 5
        adj.add(new ArrayList<>());
        adj.get(5).add(6);

        // index 6
        adj.add(new ArrayList<>());

        // index 7
        adj.add(new ArrayList<>());
        adj.get(7).add(5);

        // index 8
        adj.add(new ArrayList<>());
        adj.get(8).add(9);
        adj.get(8).add(2);

        // index 9
        adj.add(new ArrayList<>());
        adj.get(9).add(10);

        // index 10
        adj.add(new ArrayList<>());
        adj.get(10).add(8);

    }
}
