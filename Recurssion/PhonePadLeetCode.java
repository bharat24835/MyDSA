package Practise;

import java.util.ArrayList;
import java.util.List;

public class PhonePadLeetCode {
    public static void main(String[] args) {
        String digits = "76";
        List<String> ans = letterCombinations( digits);
        System.out.println(ans);


    }
    public static List<String> letterCombinations(String digits) {


        List<String> list = new ArrayList<>();
        if(digits.isEmpty())
            return list;
        String p="";
        call(digits, p , list);
        return list;
       // System.out.println(list);
    }
    public static void call(String up, String p , List<String> list)
    {
        if(up.isEmpty())
        {
            list.add(p);
            return;
        }
        int digits = (int)(up.charAt(0) - '0'); // this will convert '2' to 2
        int aukat = call1(digits);
        int had = call2(digits);
        for(int i =(digits-2)*3+aukat ; i<(digits-1)*3+had  ; i++)
        {
            char ch =(char) ('a' + i);
            call(up.substring(1) , p+ch, list);
        }
        return;
    }
    public static int call1(int digits)
    {
        if(digits<=7)
            return 0;
       else
           return 1;
    }
    public static int call2(int digits)
    {
        if(digits==9)
            return 2;
        if (digits== 7|| digits==8)
            return 1;
        else return 0;

    }
}
