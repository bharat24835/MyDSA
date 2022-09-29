package LeetCodePractise;

import java.util.ArrayList;

public class Grammar779 {
    public static void main(String[] args) {
        int n = 4;
        int k=9;
        int ans = kthGrammar(n,k);
        System.out.println(ans);

    }
    public  static int kthGrammar(int n, int k) {
        if(n==1|| k==1)
            return 0;
        String list = "";
        if(n==2||k==2)
            return 1;
        list= list+"01";
        int start = list.length()/2;
        int end = list.length()-1;
        list=  call( start,end, n , list);
        char ans =(list.charAt(k-1));
        int val = (int)(ans-'0');
        return val;
    }
    public static String call( int start, int end , int n, String list)
    {
        String lsit2 = new String();
        if(n==2)
            return list;
        int mid = list.length()/2;
        for(int i = mid; i<=end; i++)
        {
            if(list.charAt(i)=='0')
                lsit2=lsit2+"01";
            else
                lsit2=lsit2+ "10";
        }
        list=list+lsit2;
     return    call(end+1, list.length()-1,n-1,list);

    }
//    public   int kthGrammar(int n, int k) {
//        if(n==1 &&  k==1)// 779 leetcode problem
//            return 0;
//        int midindex  = (int)Math.pow(2,n-1)/2;
//
//        if(k<=midindex)
//            return kthGrammar(n-1,k);
//        else
//        {
//            if(kthGrammar(n-1,k-midindex)==0)
//                return 1;
//            else
//                return 0;
//        }
//    }
}
