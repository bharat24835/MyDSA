package Practise;

public class p2 {
    public static void main(String[] args) {
        String s1 = "mississippi";
        String s2 = "issip";
        int ans =  call (0,0,s1,s2);
        System.out.println("Answer is : " + ans);

    }
    public static int call(int i , int j , String s1, String s2){
        if(j == s2.length())return i - s2.length();
        if(i == s1.length()) return -1;

        // match
        int first = -1;
        if(s1.charAt(i) == s2.charAt(j))
             first =  call(i+1, j+1, s1,s2);

        int second = call(i+1,0,s1,s2);

        if(first !=-1 && second !=-1) return Math.min(first,second);
        if(first != -1) return first;
        else return second;
    }
}
