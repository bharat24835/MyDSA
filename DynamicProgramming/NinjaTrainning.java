package DynamicProgramming;

import java.util.Arrays;

public class NinjaTrainning {
    public static void main(String[] args) {
        int [][]  a =  {{2,1,3},
                        {3,4,6 },
                        {10,1,6 },
                        {8,3,7}};
        int n =4;

        int[][]dp2 = new int[n][4];
        for (int[] row: dp2)
            Arrays.fill(row, -1);

        int[][]dp3 = new int[n][4];   // why we are using dp of column size =4;
        // first option for us to choose is from 3 element with last activut = 3(no activity previously done)
        for(int[] r : dp3){
            Arrays.fill(r,-1);
        }

        System.out.println(" here we predict the maximum numenr of points ");
        System.out.println("Answer by Recurssio : "  + call( n-1,3 ,a));
        System.out.println(" Answer by Memoization: " + call2(n-1, 3,a,dp2));
        for(int [] b : dp2){
            System.out.println(Arrays.toString(b));
        }
        System.out.println("Answer by Tabulation: " + call3(n, a, dp3) );
        for(int [] b : dp3){
            System.out.println(Arrays.toString(b));
        }

    }
    public static  int call( int days ,int last , int[][]a){

        if(days == 0){

            int max =0;
            for(int i =0 ; i<3; i++){
                if(i != last){
                    max= Math.max(max, a[0][i]);
                }
            }
            return  max;
        }

        int max= 0;

        for(int i=0; i<3; i++){
            if(i!= last){

                int point = a[days][i]  + call(days-1 , i ,a);
                max = Math.max(max, point);
            }
        }
        return max;

    }
    public static  int call2( int days ,int last , int[][]a, int[][]dp2){

        if(days == 0){

            int max =0;
            for(int i =0 ; i<3; i++){
                if(i != last){
                    max= Math.max(max, a[0][i]);
                }
            }
            return dp2[days][last]= max;
        }
              if(dp2[days][last] != -1) return  dp2[days][last];
        int max= 0;

        for(int i=0; i<3; i++){

            if(i != last){
                int point = a[days][i]  + call2(days-1 , i ,a,dp2);
                max = Math.max(max, point);
            }
        }
        return dp2[days][last] = max;

    }

    public static int call3( int n, int[][]a , int[][]dp3 ){
        // intilasing base value
        dp3[0][0] = Math.max(a[0][1], a[0][2]);
        dp3[0][1] = Math.max(a[0][0], a[0][2]);
        dp3[0][2] = Math.max(a[0][1], a[0][0]);
        dp3[0][3] = Math.max(Math.max(a[0][1], a[0][2]) , a[0][0]);

        for(int day=1 ; day<n; day++){

            // we use last = 4 , ek row aisee bhi hai jahan we have option to start anyone of activity
            for(int last = 0; last<4; last++){
                int max= 0;
                for(int task = 0 ; task<3; task++){
                    if(task != last){
                        int points = a[day][task] + dp3[day-1][task];
                        max = Math.max(max, points);
                    }
                }
                dp3[day][last] = max;
            }
        }
        return dp3[n-1][3];
    }
}
