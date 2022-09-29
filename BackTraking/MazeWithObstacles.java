package Backtraking;

import java.util.ArrayList;

public class MazeWithObstacles {
    public static void main(String[] args) {
       boolean[][] maze = {
               {true,true,true},
               {true, false,true},
               { true, true,true}
       };
      ArrayList<String > list = new ArrayList<>();
      String p = "";
      call( 0,0,list,p, maze);
        System.out.println(list.toString());
      }
      public static void call(int row , int col ,ArrayList<String> list, String p, boolean[][]maze)
      {
          if(row==maze.length-1 && col==maze[0].length-1)
          {
              list.add(p);
              return;
          }
          if(maze[row][col]==false)
          {
              return;
          }
          if (row<maze.length-1)
              call(row+1, col, list, p+"D", maze);
          if(row<maze.length-1 && col<maze[0].length-1)
              call(row+1, col+1, list, p+"d", maze);
          if(col<maze[0].length-1)
              call(row, col+1, list,p+"R", maze);
          return;
      }
}
