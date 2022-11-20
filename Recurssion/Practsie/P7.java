package Bharat.Practsie;

public class P7 {
    public static void main(String[] args) {
        String a = new String("Hello");
        System.out.println(" Stirng is : " + a);
        String b = new String();

        System.out.println(call(a,b));

    }
    public static String call(String a, String b ){
        if(a.isEmpty()){
            return b ;
        }
      return  call(a.substring(1),  a.charAt(0)  + b  );
    }
}
