package Bharat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WrongArrayDuplicates {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" Here we wisht to print the subset for the arrray: : ");
        int []a = { 1,2,2};

        List<List<Integer>> list = call( a);
        System.out.println(list);
    }
    public static List<List<Integer>> call( int[]a)
    {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        for (int n = 0 ; n<a.length; n++)
        {
            if(n>0 && a[n] == a[n-1])
                n++;
            else
            {
            int s = outer.size();
            for (int i=0 ; i<s; i++)
            {
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(a[n]);
                outer.add(inner);
            }
            }


        }
        return outer;
    }
}
