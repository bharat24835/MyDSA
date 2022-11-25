package Practise;

import java.util.ArrayList;

public class P1 {
    public static void main(String[] args) {
        String up = "abc";
        ArrayList<String> list = new ArrayList<>();
         call(new String(""), up,list);

        System.out.println(list);
    }
    public static  void call( String p, String up, ArrayList<String> list){
        if(up.isEmpty()){
            list.add(p);
            return;
        }
        call(p+up.charAt(0), up.substring(1), list);
        call(p, up.substring(1), list);

    }
}
