package Backtraking;

import java.util.ArrayList;

public class PrintingPathAndDiagonalAlso {
    public static void main(String[] args) {
        int row=3;
        int col =3;
        String p ="";
        ArrayList<String> list= new ArrayList<>();
      call(p, row,col, list);
        System.out.println(list.toString());

    }
    public static void call( String p , int row, int col, ArrayList<String> list)
    {
        if(row==1 && col==1)
        {
            list.add(p);
            return;
        }
        if(row>=1)
         call(p+"D", row-1, col,list);
        if (row>=1 && col>=1)
            call(p+"d", row-1, col-1, list);
        if (col>=1)
         call(p+"R", row,col-1,list);
         return;


    }
}
