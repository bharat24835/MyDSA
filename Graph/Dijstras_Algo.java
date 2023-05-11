package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijstras_Algo {
    public static void main(String[] args) {
        // first we need to create an adjency list
        List<List<PairD>> adj = new ArrayList<>() ;
        getList(adj);

        int V = 6;
        int source = 0;
        PriorityQueue<PairD> pq = new PriorityQueue<>((a,b)-> a.first-b.first);
        int []dist = new int[V];
        int []parent = new int[V];
        // fillign dist
        Arrays.fill(dist,(int)1e9);
        // fillinf parent with their index
        for(int i = 0 ; i<V; i++){
            parent[i] = i;
        }

        dist[0] = 0;
        // in pq we push in form of (distance , node);
        pq.add(new PairD(0,0));
        while(!pq.isEmpty()){
               PairD temp = pq.poll();
               int node = temp.second;
               int d = temp.first;

               for(PairD temp1  : adj.get(node)){
                   // adj list mai (node , weight ) ki form mai data enter hai
                   int edgeweight = temp1.second;
                   int adjnode = temp1.first;

                   // check condition
                   if(d + edgeweight < dist[adjnode]){
                       dist[adjnode] = d + edgeweight;
                       // ipdaitng parent
                       parent[adjnode] = node;
                       pq.offer(new PairD(dist[adjnode] , adjnode));
                   }
               }
        }

        System.out.println(Arrays.toString(dist));
        System.out.println(Arrays.toString(parent));

        System.out.println("Now we wisht to print the shortest path : ");
        List<Integer> path = new ArrayList<>();
        int temp = 5;
        while(parent[temp] != temp){
            path.add(0,temp);
            temp = parent[temp];
        }
        path.add(0,0);
        System.out.println(path);


    }
    public static void getList(List<List<PairD>> adj){
        //node 0
        adj.add(new ArrayList<>());
        adj.get(0).add(new PairD(1,4));
        adj.get(0).add(new PairD(2,4));

        // node 1
        adj.add(new ArrayList<>());
        adj.get(1).add(new PairD(0,4));
        adj.get(1).add(new PairD(2,2));

        // node 2
        adj.add(new ArrayList<>());
        adj.get(2).add(new PairD(0,4));
        adj.get(2).add(new PairD(1,2));
        adj.get(2).add(new PairD(3,3));
        adj.get(2).add(new PairD(4,1));
        adj.get(2).add(new PairD(5,6));

        // node 3
        adj.add(new ArrayList<>());
        adj.get(3).add(new PairD(2,3));
        adj.get(3).add(new PairD(5,2));

        // node 4
        adj.add(new ArrayList<>());
        adj.get(4).add(new PairD(2,1));
        adj.get(4).add(new PairD(5,3));

        // node 5
        adj.add(new ArrayList<>());
        adj.get(5).add(new PairD(2,6));
        adj.get(5).add(new PairD(3,2));
        adj.get(5).add(new PairD(4,3));

    }
}
class PairD{
    int first;
    int second;
    PairD(int a , int b){
        this.first = a;
        this.second = b;
    }
}
