package Bharat;

import java.util.Scanner;

public class RemoveA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" Here we wish to code for recurssion : ");
        StringBuilder  a = new StringBuilder("bharat");
        StringBuilder ans  = new StringBuilder("");
        System.out.println(" Here we wish to remoce all a from it , usign recursison: ");
        call(ans, a);

    }
    public static void call( StringBuilder ans, StringBuilder a)
    {
        if(a.isEmpty()) {
            System.out.println(ans);
            return;
        }
        char ch =  a.charAt(0);
        if(ch == 'a')
        {
            call(ans, new StringBuilder(a.substring(1)));
        }
        else
            call(ans.append(ch), new StringBuilder(a.substring(1)));
return;
    }
}
