package RecurssionGFG;

public class FirstUpperCaseLetter {
    public static void main(String[] args) {
        String up = "HELLO";
        String p = "";
       String ans =   call(up ,p);
        System.out.println(ans);
    }
    public static String call( String up , String p)
    {
        char ch = up.charAt(0);
        if(ch<'A' || ch>'Z')
            return call(up.substring(1), p);
                return Character.toString(ch);

    }
}
