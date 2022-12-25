package Practise;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintingPath {
    public static void main(String[] args) {
        System.out.println(" We will consider that the array is of 3*3: ");
        boolean [][] matrix = {
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
        int [][]maze = new int[matrix.length][matrix[0].length];
        ArrayList<String> list = new ArrayList<>();
        String p="";
        int step =1;
        call(p,0,0,list, matrix, step,maze);

    }
    public static void call(String p ,int row, int col, ArrayList<String> list, boolean[][]matrix,int step, int [][]maze)
    {
     if(row==matrix.length-1 && col==matrix[0].length-1)
     {
         maze[row][col]=step;
        for (int []arr: maze)
        {

            System.out.println(Arrays.toString(arr));
        }
         System.out.println(p);
         System.out.println();
return;
     }
     if(matrix[row][col]==false)
         return;

     matrix[row][col]=false;
     maze[row][col]=step;
     if (col<matrix[0].length-1)   // parsing right condition
     {
         call(p+"R", row, col+1, list,matrix,step+1,maze);
     }
     if(col>0)     // parsing left condition
     {
         call(p+"L", row,col-1, list, matrix, step+1,maze);
     }
     if(row>0)     // parisn up condition
     {
         call(p+"U", row-1, col, list, matrix, step+1, maze);
     }
     if(row<matrix.length-1) // parsing down conditon
     {
         call(p+"D" ,row+1, col, list, matrix, step+1, maze);
     }

     matrix[row][col]=true;
     maze[row][col]= 0;
     return;
    }
}
