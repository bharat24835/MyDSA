package New;

import java.util.ArrayList;

public class CountPathWithObstacles {
    public static void main(String[] args) {
        System.out.println(" Counting the path with obstacles");
        boolean [][] board= {
                {true,true,true},
                {true,false,true},
                {true,true,true}
        };
        ArrayList<String> list = new ArrayList<>();
        String  p = "";
        call(0,0,p,list,board);
        System.out.println(list);
    }
    public static void call( int row, int col, String p , ArrayList<String> list , boolean[][]board){
        if(board[row][col]==false)
            return;
        if(row==2 && col==2){
            list.add(p);
            return;
        }
        // parsing right
        if(col<2)
        call(row,col+1,p+'R',list,board);
        // parisng down
        if(row<2)
        call(row+1,col,p+'D',list,board);
        return;
    }
}