package Practise;

import java.util.Arrays;

public class p5 {
    public static void main(String[] args) {
        int[]a = {0,0,1,-1};

        int ans  =  call( a);
        System.out.println("Count will be :  " + ans);

        System.out.println(Arrays.toString(a));
    }
    public static int call( int[]a){
        int count1 = 0 ;
        int count  = 0;
        for( int i = 0 ; i<a.length; i++){

            // this will move the pointer to first captured fort
            // means first occurence of a[i] == 1
            while( i<a.length && a[i]!=1){
                i++;
            }
            // now capturing works here
            while( i<a.length && a[i]!=-1){
                if(a[i] == 0){
                    count++;
                    a[i] = 1;
                }
                i++;

            }
        }

        for (int i =a.length-1; i>=0 ; i--){

            while( i>=0 && a[i]!=1){
                i--;
            }

            while( i>=0 && a[i]!=-1){
                if (a[i] == 0){
                    count1++;
                    a[i] = 1;
                }
                i--;
            }
        }
        return Math.max(count,count1);

    }
}
