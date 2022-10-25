package Bharat;

import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner in = new Scanner( System.in);
        System.out.println(" Here we wisht to convert Deciaml to binary : ");
        long ans = call(1);
        System.out.println(ans);

    }
    public static long call(int n){

        if(n==1)return 1;
        return     call(n/2)*10 + n%2;
    }
}
