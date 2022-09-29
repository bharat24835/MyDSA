package New;

import java.util.ArrayList;

public class TBCount {
    public static void main(String[] args) {
        System.out.println(" Here we wisht to print path : ");
        String p ="";
        ArrayList<String> list = new ArrayList<>();
         call( 0,0,p,list);
        System.out.println(list);
    }
    public static void call( int row, int col, String p,ArrayList<String> list){
        if(row==2 && col==2){
            list.add(p);
        }
        if(row<2) //  down in allowed
            call(row+1,col,p+'D',list);
        if(col<2)// right is allowed
            call(row,col+1, p+'R',list );
        return;
    }
}
