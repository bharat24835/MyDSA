package LeetCodePractise;

public class Grammar7792 {
    public static void main(String[] args) {
        int n = 3;
        int k=4;
        int ans = kthGrammar(n,k);
        System.out.println(ans);

    }

    public static int kthGrammar(int n, int k) {
        if(n==1 &&  k==1)
            return 0;
        int midindex  = (int)Math.pow(2,n-1)/2;

        if(k<=midindex)
            return kthGrammar(n-1,k);
        else
         //   return !kthGrammar(n-1,k-midindex);
        {
            if(kthGrammar(n-1,k-midindex)==0)
                return 1;
            else
                return 0;
        }
    }

}
