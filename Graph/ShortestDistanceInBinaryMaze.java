package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceInBinaryMaze {
    public static void main(String[] args) {
        int[][]a = {{0,0,0},
                {1,1,0},
                {1,1,0}};
        System.out.println(" Here we wisht to find teh shotest dist form : " + call(a));
    }
    public static int call(int[][]a){
        int n = a.length;
        int m = a[0].length;

        int[][]dis  = new int[n][m];
        int[][]vis = new int[n][m];
        for(int [] b : dis){
            Arrays.fill(b,(int)1e9);
        }
        // makign soruze dis[sourse ] = 0;
        dis[0][0] = 0;
        Queue<Pair1> q = new LinkedList<>();
        q.offer(new Pair1(0,0,0));
        vis[0][0] = 0;
        // (dis, row, col);

        while(!q.isEmpty()){
            Pair1 temp =  q.poll();
            int d = temp.x;
            int r = temp.y;
            int c = temp.z;

            for(int i = -1; i<=1; i++){
                for(int j =-1 ; j<=1; j++){
                    int di = i + r;
                    int dj = j + c;

                    if(di>=0 && di<n && dj>=0 && dj<m &&  (1 + d) < dis[di][dj] && a[di][dj] == 0){
                        vis[di][dj] = 1;
                        dis[di][dj] = d +1;
                        if(di == n-1 && dj== m-1) return d+1;
                        q.offer(new Pair1(d+1, di, dj));
                    }

                }
            }


        }
        return -1;
    }

}
 class Pair1{
    int x;
    int y;
    int z;
    Pair1(int a, int b , int c ){
        this.x = a;
        this.y = b;
        this.z = c;
    }
}
