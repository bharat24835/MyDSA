package Practise;

import java.util.Arrays;

public class p11 {
    public static void main(String[] args) {
     int[]a = {1,2,3};
     int[]b = a;
     b[0] = 4;
        System.out.println(b.equals(a));
        System.out.println(b==a);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}
