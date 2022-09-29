package New;

public class CountWays {
    public static void main(String[] args) {
        System.out.println(" Here we wish to count number of ways to tarch particular row and col :");

        int ways = call( 0,0 );
        System.out.println(ways);

    }
    public static int call( int row, int col){
        if(row==2 || col==2)
            return 1;


            int down = call(row+1,col);

            int right = call(row,col+1);
            return (down+right);

    }
}
