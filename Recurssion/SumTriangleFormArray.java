package RecurssionGFG;

import java.util.ArrayList;
import java.util.List;

public class SumTriangleFormArray {
    public static void main(String[] args) {
        int[]a = {1,2,3,4,5};
        List<List<Integer>> list = new ArrayList<>();
        call(a,list);
        System.out.println(list);
    }
    public static void call(int[]a, List<List<Integer>> list)
    {

        if(a.length<1)
            return;

       // list.add(new ArrayList<>());
        List<Integer> inner = new ArrayList<>();
        int[]lol = new int[a.length-1];
        int k =0;
        for (int i =0 ; i<a.length-1; i++)
        {
            int temp = a[i]+a[i+1];
            lol[k++]= temp;
            inner.add(temp);
        }


         call(lol,list);
        list.add(inner);

    }
}
