package CodeChef;

import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0){
            int x = in.nextInt();
            int y = in.nextInt();
            if(x==y)
                System.out.println("Neutral");
            else if (x > y) {
                System.out.println("Loss");
            }
            else
                System.out.println("Profit");
        }
    }
}
