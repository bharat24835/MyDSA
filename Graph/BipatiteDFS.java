package Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class BipatiteDFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        createadj(adj);

        int []color = new int[9];
        Arrays.fill(color,-1);
        // -1 means not colorued;
        // we have to check / start usign connected components
        for (int i =1 ; i< adj.size(); i++){
            if(color[i] == -1 && dfs( i , color, adj) == false)
                System.out.println("Graph is Bipatite :  -  No (False)");
        }
        System.out.println("Check conditons");
    }
    public static boolean dfs( int element, int[]color,   ArrayList<ArrayList<Integer>> adj ){
        int c = color[element];

        for(int temp : adj.get(element)){
            if(color[temp] == -1){
                color[temp] = (c+1)%2;
                return dfs(temp,color,adj);
            }
            else if(color[temp] != -1 && color[temp] == c){
                return false;
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
