package Bharat;

import java.util.Scanner;

public class RemoveString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" HEre we wish to return the string :" );
        String a = "where is apple . I think it is missing and what about the app I think it is missing:";
        String b = call(a);
        System.out.println(b);
    }
    public static String call( String a)
    {
        if(a.isEmpty())
            return "";
        if(a.startsWith("app") && !a.startsWith("apple"))
        {
            return call(a.substring(5));
        }
        else
            return a.charAt(0)+call(a.substring(1));
    }
}
