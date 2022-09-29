package LinklistQuestion;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(" Here we wish to find wheather the number is happy or not : ");
        int a= 19;
        System.out.println(call(a));
    }
    public static boolean call( int n){
        int slow = n;
        int fast = n;
        do{
            fast=square(square(fast));
            slow = square(slow);
        }while (fast!=slow);
        if(slow==1)
            return true;
        else
         return    false;
    }
    public static int square( int n){
        int ans =0;
        while(n>0){
            int rem = n%10;
            ans+=rem*rem;
            n=n/10;
        }
        return ans;
    }
}
// normally we have problem regarding why we use line 16-- line 19

