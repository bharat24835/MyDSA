package Practise;

import java.util.Arrays;

public class p6 {
    public static void main(String[] args) {
        int[]a = {-1,-1,0,1,0,0,1,-1,1,0};
        System.out.println(call(a));
        System.out.println(Arrays.toString(a));
    }
    public  static int call( int[]a){
      int count  = 0;
       for( int  i = 0 ; i<a.length ; i++){
           if(a[i] !=1 )
               continue;;
           for (int j = 0 ; j<a.length ; j++){
               if(a[j] != -1 || i == j )
                   continue;

               int temp  = call1( a , i,j);


               count  = Math.max(temp,count);
           }

       }


return count;
    }
    public static int call1( int[]a, int start, int end){
        int first = Math.min(start,end);
        int second = Math.max(start , end);
        int count = 0;
        for( int i = first+1;i<second  ; i++){
            if(a[i] == -1 || a[i] == 1) return 0 ;
            if(a[i] == 0) {
                count++;
                a[i] = 1;
            }
        }
        return count;
    }
}
