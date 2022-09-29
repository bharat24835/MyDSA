package RecurssionGFG;

public class LengthOfString {
    public static void main(String[] args) {
        String up = "Hello";
        int count =0;
        count = call( up, count);
        System.out.println(count);

    }
    public static int call(String up, int count)
    {
        if(up.isEmpty())
            return count;
         return  call(up.substring(1), count+1);

    }
}
