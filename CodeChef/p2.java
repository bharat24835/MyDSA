package CodeChef;

import java.util.Scanner;

public class p2 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int t= in.nextInt();

        while (t-- > 0){

            int x = in.nextInt();
            int y = in.nextInt();
            int count = 0;
//            for( int i = x ; i<=y ; i++){
//                if( Math.abs(x - i) == Math.abs( y -i))
//            }
            int mid = (x+y);
            if(mid % 2 != 0){
                System.out.println("-1");
            }else
                System.out.println(mid/2);
        }
    }
}
