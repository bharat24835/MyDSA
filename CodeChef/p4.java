package CodeChef;

import java.util.Arrays;
import java.util.Scanner;

public class p4 {
    public static void main(String[] args) {
        Scanner  in = new Scanner(System.in);
        System.out.println(" Enteer test case : ");
        int t  = in.nextInt();

        while( t-- > 0){
            System.out.println(" Enter : N ,X C");
            int n = in.nextInt();
            int rpValue = in.nextInt();//i.e X
            int rwValue = in.nextInt(); // i.e C

            int sum = 0;
            int count =0;
            int rwSum = 0;
            int []a = new int[n];
            System.out.println("Enter the array value");
            for( int i = 0 ; i< n; i++){
                a[i] = in.nextInt();
                sum += a[i];
            }
            Arrays.sort(a);

            for( int i =0; i<n; i++){
                if((rpValue - a[i] ) > rwValue){
                    sum -= a[i];
                    sum += rpValue;
                    rwSum += rwValue;
                    count++;

                }
            }
            System.out.println(" Answer is " + (sum - rwSum));
            System.out.println(" Number of opreation we did" + count);


        }
    }
}
