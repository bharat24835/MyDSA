package com.company;

import java.util.Arrays;
import java.util.Scanner;

//import static jdk.internal.org.jline.utils.Colors.s;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner  in = new Scanner(System.in);
          int []a ={ -4,2,3,4,7,8,2,5,4,1,9,8,7,6,0,2,3,4,-1};
        System.out.println(" Here we want to do Insertion Sort: ");
        for (int i = 0; i < a.length - 1; i++)
        {
            for (int j = i+1; j >0 ; j--)
            {
            if (a[j-1] > a[j]) {
                Swap(a, j,j-1);
            } else break;
            }
        }
        System.out.println(Arrays.toString(a));
        System.out.println(" ❤❤❤💕💕💕😁😉🎉🎂✔👱‍♂️👱‍♂️👱‍♂️👸🤴🤴🧨🥐 ");
    }
    public static void Swap(int[]a,int c, int b)
    {
        int temp=a[c];
        a[c]=a[b];
        a[b]=temp;
    }

}
