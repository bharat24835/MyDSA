package Practise;

public class p9 {
    public static void main(String[] args) {
        int n = 5;
        int[]a = {1,0,0,0,1};
        System.out.println("Ans is :  " + toggle(n,a));

    }
    public static int toggle(int n, int[] a) {
        // code here
        int max = 0;
        for(int i= 0 ; i<a.length ; i++){
      int j = i;


                int count = 0;
                while(j<a.length && a[j] != 0){
                    count++;
                    j++;
                }
                while( j < a.length && a[j]!= 1 ){
                    count++;
                    j++;
                }
                while(j < a.length && a[j]!=0){
                    count++;
                    j++;
                }
                max = Math.max(max,count);
        }
        return max;
    }
}
