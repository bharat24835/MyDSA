package DynamicProgramming;

public class EditDistance {
    public static void main(String[] args) {
        String s1 = "intention";
        String s2 = "execution";
        System.out.println("NUmbe of Operation to  make s1 to look  like s2 : " );
        System.out.println( "Answer by Recurssion : " + call( s1.length()-1, s2.length()-1, s1,s2));
        System.out.println("Answer by Tabulation : " + call2(s1,s2));
    }
    public static int call(int i , int j , String s1, String s2){
        if(i<0)return j+1;
        if(j<0) return i+1;

        if(s1.charAt(i) == s2.charAt(j)){
            return 0 + call(i-1,j-1,s1,s2);
        }
        else {
            int add = call(i,j-1,s1,s2);
            int remove = call(i-1,j,s1,s2);
            int replace = call(i-1,j-1,s1,s2);
            return Math.min(add,Math.min(remove,replace)) +1;
        }
    }
    public static int call2(String s1 , String s2){
        int n = s1.length();
        int m = s2.length();
        int[][]dp = new int[n+1][m+1];

        // declare base case;
        for(int i = 1 ; i<=n ; i++) dp[i][0] = i+1;
        for(int j = 1 ; j<=m ; j++) dp[0][j] = j+1;

        // for loop
        for(int i = 1 ; i<=n ; i++){
            for(int j = 1; j<=m ; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 0 + dp[i-1][j-1];
                }
                else{
                    int add = dp[i][j-1];
                    int remove = dp[i-1][j];
                    int replace = dp[i-1][j-1];

                    dp[i][j]  = 1 + Math.min(add,Math.min(remove,replace)) ;
                }
            }
        }
        return dp[n][m];
    }
}
