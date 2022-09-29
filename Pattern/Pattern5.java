package com.company;

import java.util.Scanner;

public class Pattern5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" HEre we wish to print pattern 5: ");
        int num = in.nextInt();
        int count =1;
        for ( int i =1; i <= (2*num-1); i++ )
        {
              if( i> num)
                   count = num - i%num;
                  else
                      count = i;

            for (int j =1 ; j<= count ; j++)
            {
                System.out.print("* ");
            }
            System.out.println("");
            if(i<num)
                count++;
        }
    }
}
