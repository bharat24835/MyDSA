package Bharat;

import java.util.Scanner;

public class RemoveString2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" Here we wish to do some probels ");
        String a = "hello how are you we are doing some great work: ";
        String b = "are";
        String list= new String();
        list = call( a, b , list);
        System.out.println(list);
    }
    public static String call ( String a ,String b, String list)
    {
        if(a.isEmpty()) {
            return list;
        }
        if(a.startsWith(b))
            return call(a.substring(b.length()) , b, list);
        else
        {
            list = list+a.charAt(0);
            return  call(a.substring(1), b, list);

        }
     //   return list;

    }
}
