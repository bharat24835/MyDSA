package Bharat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PowerSetArrayWithoutDuplicates {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" Here we wisht to print the subset for the arrray: : ");
        int []a = { 1,2,3};

        List<List<Integer>> list = call( a);
        System.out.println(list);
    }
    public static List<List<Integer>> call( int[]a)
    {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        for (int n : a)
        {
            int s = outer.size();
            for (int i=0 ; i<s; i++)
            {
               List<Integer> inner = new ArrayList<>(outer.get(i));
               inner.add(n);
               outer.add(inner);
            }

        }
        return outer;
    }
}
