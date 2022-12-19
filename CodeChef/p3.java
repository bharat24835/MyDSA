package CodeChef;

import java.util.Scanner;

public class p3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while(t-- > 0){
            int n = in.nextInt();
            int x = in.nextInt();
            int sum = (int)Math.pow(2,x);
            for(int  i =1 ; i<=n ;i++){
                sum/=2;

            }
            System.out.println(sum);
        }
    }
}
