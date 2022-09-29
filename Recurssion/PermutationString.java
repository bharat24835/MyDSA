package Bharat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationString {
    public static void main(String[] args) {
        String up = "abc";
        String p = "";
       List<String> op = new ArrayList<>();
       int count[] ={0};
              call(p, up, op, count);
        System.out.println(op);
        System.out.println(" Number of permutation are s: " + Arrays.toString(count));


    }
    public static  void call (String p, String up, List<String> op, int[] count)
    {


        if(up.isEmpty())
        {
             op.add(p);
             count[0]++;
            return ;
        }
        char ch = up.charAt(0);

        for( int i =0; i<=p.length() ; i++)
        {
            String first = p.substring(0, i);
            String seconf = p.substring(i,p.length());
            call(first+ch+seconf,up.substring(1) , op,count);
        }
        return ;
    }
}
