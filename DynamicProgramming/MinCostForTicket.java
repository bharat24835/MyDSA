package DynamicProgramming;

public class MinCostForTicket {
    public static void main(String[] args) {
        int []a  = {1,2,3,4,5,6,7,8,9,10,30,31};
        int []c= {2,7,15};

        int ans =  call( a.length-1 , a, c);
        System.out.println(ans);

    }
    public static int call( int i , int[]a, int[]c){
        if(i<0)return 0;



        int first = c[0] + call(i-1,a,c);
        int temp = a[i];
        int i7 = i;
        // if we choose 7 day pass , so from temp we have to (temp+7) we can travel
        // so we need to iterate upto index where (temp+6)


        //choosing 7 day pass
        int temp7 = temp-6;
        while(i7>=0 && temp7 <= a[i7]){
            i7--;
        }
        int second = c[1] + call(i7, a, c);
        int i30 = i;
        int temp30 = temp - 29;
        while(i30 >=0 && temp30 <= a[i30]){
            i30--;
        }
        int third = c[2] + call(i30, a, c);

        return Math.min(first, Math.min(second, third));


    }
}
