package Practise;

import java.util.ArrayList;
import java.util.List;

public class Practise3 {
    public static void main(String[] args) {
        System.out.println(" Now we make subset without the duplicate element : ");
        int []a = {1,2,2};
        List<List<Integer>> list= call(a);
        System.out.println(list);
    }
    public static List<List<Integer>> call( int[]a)
    {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start=0;
        int end =0;// this is the actual last  index of outer list
        for( int i=0; i<a.length; i++)
        {
            start=0; // if special condition hit false, so that list start from starting
            if( i>0 && a[i]==a[i-1])
            {
                start = end +1;

            }
            end = outer.size()-1;
            int s = outer.size();
            for( int j = start; j<s; j++)
            {
                List<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(a[i]);
                outer.add(inner);
            }
        }
        return outer;
    }
}
