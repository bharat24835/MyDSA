package Bharat.Practsie;

public class P6 {
    public static void main(String[] args) {
        int n = 12345 ;
        System.out.println();
        System.out.println(" Our wish is to reverse the given number: ");
        int ans = call(n,0);
        System.out.println(" Reverse is : " +ans);
        System.out.println(" Revesrs of ans2  os :"  + call2(n));
    }
    public static int call( int num , int res){
        if(num==0) {
            return res;
        }
            return  call(num/10, res*10 + num%10);

    }
    public static  int call2 (int num ){
        if(num/10==0)
            return num;

        return   (num%10)*10  + call2(num/10) ;
    }
}
