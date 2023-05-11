package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinScore {
    public static void main(String[] args) {
        int[][]a= {{1,2,9},
                {2,3,6},
                {2,4,5},
                {1,4,7}};
        System.out.println("Answer is : " +   minScore(4,a));

    }
    public static int minScore(int n, int[][] a) {
        // here we generally goona use
        List<List<Pair>> adj = new ArrayList<>();
        int ans = Integer.MAX_VALUE;
        int[]visited = new int[n+1];

        // first we need to make adjecy list
        for(int i = 0 ; i<=n ; i++){
            adj.add(new ArrayList<>());
        }

        // forming adj list
        for(int i =0 ; i<a.length ; i++){
            int u = a[i][0];
            int v = a[i][1];
            int w = a[i][2];

            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }

        // offer stating pount
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1]= 1;
        while(!q.isEmpty()){
            int node  = q.poll();
            for(Pair temp : adj.get(node)){
                int n1 = temp.node; /// first is node
                int d = temp.parent; // second is parent
                ans  = Math.min(ans, d);
                if(visited[n1] == 0){

                    visited[n1] = 1;
                    q.offer(n1);
                }
            }
        }
        return ans;

    }
}

