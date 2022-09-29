package Backtraking;

import java.util.ArrayList;
import java.util.Scanner;

public class MazeWithObstaclesIncludingAllPath {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        boolean[][] maze = {
                {true,true,true},
                {true, true,true},
                { true, true,true}
        };
        ArrayList<String > list = new ArrayList<>();
        String p = "";
        call( 0,0,list,p, maze);
        System.out.println(list.toString());
    }
    public static void call(int row , int col ,ArrayList<String> list, String p, boolean[][]maze) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {

            list.add(p);
            return;
        }
        if (maze[row][col] == false) {
            return;
        }
        maze[row][col]=false;
        if (row < maze.length - 1)
            call(row + 1, col, list, p + "D", maze);

        // responsible for down movement
        // if(row<maze.length-1 && col<maze[0].length-1) // responsible for diagonal element
        //  call(row+1, col+1, list, p+"d", maze);

        if (col < maze[0].length - 1) // responsible for right movement
            call(row, col + 1, list, p + "R", maze);

        if (row > 0)
            call(row - 1, col, list, p + "U", maze);

        if (col > 0)
            call(row, col-1, list,p+"L", maze);

// at this line function is over
        // so before the function is over we have to make maze[row][col]=true;
        maze[row][col]=true;
        return;
    }
}
