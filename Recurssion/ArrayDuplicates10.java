package Bharat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayDuplicates10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" Here we wish to print the subset of array: ");
        int []a = {1,1,2};
        List<List<Integer>> list = subset(a);
        System.out.println(list);
    }
    public static List<List<Integer>> subset(int []a )
    {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start =0;
        int end =0;
        for (int i =0 ; i<a.length; i++)
        {
                start =0;// if it false then we want whole copy of previous list
            if(i>0 && a[i] ==a[i-1]  )
            {
                start = end+1;
            }
            end = outer.size()-1;
            int s = outer.size();
           for(int j=start; j<s; j++)
           {
               List<Integer> internal = new ArrayList<>(outer.get(j));
               internal.add(a[i]);
               outer.add(internal);
           }

        }

        return outer;
    }
    
}
