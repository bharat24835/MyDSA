package Backtraking;

import PracRecurssion.StringSubset;

import java.util.ArrayList;
import java.util.Scanner;

public class new97 {
    public static void main(StringSubset[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" Here we wish to print the subseet of String");
        String up = "abc";
        String p = "";
        ArrayList<String> list= new ArrayList<>();
        call(up,p,list);
        System.out.println(list);
    }
    public static void call(String up, String p, ArrayList<String> list){
        if(up.isEmpty()){
            list.add(p);
            return ;
        }
        char ch = up.charAt(0);
        call(up.substring(1), p+ch, list);
        call(up.substring(1), p, list);
        return ;
    }
}
