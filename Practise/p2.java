package Practise;

import java.util.ArrayList;
import java.util.List;

public class p2 {
    public static void main(String[] args) {
        List<List<Integer>> outer = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();

        inner.add(1);
        inner.add(2);
        inner.add(3);
        inner.add(4);
        System.out.println(" Inner before operation : " + inner);
        System.out.println(" Outer before operation : " + outer);
        outer.add(new ArrayList<>(inner));
        inner.remove(inner.size()-1);
        inner.add(5);
        System.out.println(" Inner after operation : " + inner);
        System.out.println(" Outer after operation : " + outer);

    }
}
