package Bharat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubsetArrayWithoutDuplicates {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int []a  = {1,2,2,2};
        System.out.println(" Here we wish to print the subset of array ");
        List<List<Integer>> list = call(a);
        System.out.println(list);
    }
    public static List<List<Integer>> call( int []a )
    {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start =0 ;
        int end = 0;
        for( int i=0 ; i<a.length; i++)
        {
            int s = outer.size();
            if(i>0 && a[i] ==a[i-1])
            {
                start = end+1;
            }
            end = outer.size()-1;

            for( int j =start; j<s; j++)
            {
                List<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(a[i]);
                outer.add(inner);

            }
        }
        return outer;
    }
}
