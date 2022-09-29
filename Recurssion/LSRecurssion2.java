package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class LSRecurssion2 {
    public static void main(String[] args) {
        Scanner  in = new Scanner(System.in);
        System.out.println(" Here we wish to recurise linear search and return arrylist : ");
        int []a  = { 1,4,2,5,4,4};
        int target = 4;
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(" Foudnd elemtnt at index : "  +  LS(a,target, 0,list));
    }
    public static ArrayList LS(int[]a, int target, int start, ArrayList<Integer> list)
    {

        if(start == a.length)
            return list;
        if(a[start] == target)
            list.add(start);
        return LS(a,target,++start,list);
    }
    // in every fucntio calls , nwe list is created but all these list are directing towards the same object
    // means different refennce are created, but all are pointed to same object

}
