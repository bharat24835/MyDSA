package Graph;

import java.util.ArrayList;

public class CycleDetectionDFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer> > adj = new ArrayList<>();
       adjListCreation(adj);
       int n = 7;
       boolean [] visited = new boolean[n+1];
        System.out.println("Here we wish to Check whether this Graph has Cycle or NOt using DFS technique");
        System.out.println("Answer is : " + call(n , adj,visited ));
    }

    public static boolean call( int n , ArrayList<ArrayList<Integer> > adj , boolean[]visited){
        // connrected componet check or from where to start

        for(int i = 1 ; i<=n; i++){
            if(visited[i] == false){
               // visited[i] = true;
                if(dfs(i ,-1, n , adj, visited))
                    return true;
            }
        }
        return false;
    }

    public static boolean dfs(int node ,int parent ,  int n , ArrayList<ArrayList<Integer> > adj , boolean[]visited){
         visited[node] = true;
       for(int nbr : adj.get(node)){

           if(visited[nbr] == false){

               if(dfs(nbr,node,n,adj,visited ))
                   return true;
           }
           else if(visited[nbr] == true && nbr != parent){
               return true;
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
        adj.get(3).add(6);

        // index 4 list
        adj.add(new ArrayList<>());
        adj.get(4).add(3);

        // index 5 list
        adj.add(new ArrayList<>());
        adj.get(5).add(2);
        adj.get(5).add(7);

        // index 6 list
        adj.add(new ArrayList<>());
        adj.get(6).add(3);
        adj.get(6).add(7);

        // index 7 list
        adj.add(new ArrayList<>());
        adj.get(7).add(5);
        adj.get(7).add(6);
    }
}
