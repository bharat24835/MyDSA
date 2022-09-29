package Bharat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Subs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" Here we wish to print all the subsets of String");
        String a = "abc";
        String b="";
        ArrayList<String> list = new ArrayList<>();
        call(a,b,list);
        System.out.println(" Answer is : " + list);
    }
    public static void call(String a, String b , ArrayList<String> list)
    {
        if(a.isEmpty()){
            list.add(b);
            return;
        }
        char ch = a.charAt(0);
        call(a.substring(1), b+ch,list);
        call(a.substring(1), b,list);
       // call(a.substring(1), b+(ch+0),list);
        return;
    }
}
