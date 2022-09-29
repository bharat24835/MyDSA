package Backtraking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PrintingPath {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        boolean[][] maze = {
                {true,true,true},
                {true, true,true},
                { true, true,true}
        };
        ArrayList<String > list = new ArrayList<>();
        String p = "";
        int [][]path = new int[maze.length][maze[0].length];
        call( 0,0,list,p, maze, path, 1 );
       // System.out.println(list.toString());
    }
    public static void call(int row , int col ,ArrayList<String> list, String p, boolean[][]maze, int [][]path, int step) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {

            for (int []arr: path) {
                path[row][col]=step;
                System.out.println(Arrays.toString(arr));


            }
            System.out.println(p);
            System.out.println();
        }
        if (maze[row][col] == false) {
            return;
        }
        maze[row][col]=false;
        path[row][col]=step;
        if (row < maze.length - 1)
            call(row + 1, col, list, p + "D", maze,path,step+1);

        // responsible for down movement
        // if(row<maze.length-1 && col<maze[0].length-1) // responsible for diagonal element
        //  call(row+1, col+1, list, p+"d", maze);

        if (col < maze[0].length - 1) // responsible for right movement
            call(row, col + 1, list, p + "R", maze,path, step+1);

        if (row > 0)
            call(row - 1, col, list, p + "U", maze, path, step+1);

        if (col > 0)
            call(row, col-1, list,p+"L", maze,path, step+1);

// at this line function is over
        // so before the function is over we have to make maze[row][col]=true;
        maze[row][col]=true;
        path[row][col]=0;
        return;
    }
}
