package Practise;

import java.util.Arrays;

public class p11 {
    public static void main(String[] args) {
  int[]a = {1,1,2};
        int start = 0;
        int end = a.length-1;
        while(start <= end){
            int mid = start + (end - start )/2;

            if( mid <a.length-1 && a[mid] == a[mid+1]){
                start = mid;
            }
            else if (mid >0 && a[mid] == a[mid-1]){
                end = mid;
            }
            else{
                System.out.println("ELemnet is : " + a[mid]);
                break;
            }
        }
}
}
