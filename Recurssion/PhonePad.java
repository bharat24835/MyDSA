package Bharat;

import java.util.ArrayList;
import java.util.Scanner;

public class PhonePad {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" Here we wisht to print the pad number: ");
        String up = "23";
        String p = "";
        ArrayList<String> list = new ArrayList<>();
        call(up , p , list);
        System.out.println(list.toString());
        System.out.println(" Now we look for count : ");
        int call = count( up ,  p );
        System.out.println(call);

    }
    public static void call( String up, String p , ArrayList<String> list)
    {
     if(up.isEmpty())
     {
         list.add(p);
         return;
     }
     int digits = (int)(up.charAt(0) - '0'); // this will convert '2' to 2
        for(int i = (digits-1)*3; i<digits*3; i++)
        {
            char ch =(char) ('a' + i);
            call(up.substring(1) , p+ch, list);
        }
        return;
         }
    public static int count( String up, String p )
    {
        if(up.isEmpty())
        {

             return 1 ;
        }
        int digits = (int)(up.charAt(0) - '0'); // this will convert '2' to 2
        int count=0;
        for(int i = (digits-1)*3; i<digits*3; i++)
        {
            char ch =(char) ('a' + i);
           count = count+  count(up.substring(1) , p+ch);
        }
        return count;
    }
}
