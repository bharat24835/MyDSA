package DynamicProgramming;

public class MinInsertionToMakeStringPalindromic {
    public static void main(String[] args) {
        String a = "bbbab";
        String b ="babbb";
//        StringBuilder sb = new StringBuilder();
//        sb.append(a);
//        sb.reverse();
//        b = sb.toString();
       int ans =   a.length() - call(a,b);
        System.out.println("Answer is : " + ans);

    }
    public static int call(String s1 , String s2){
        int[]prev = new int[s2.length()+1];

        // declaring base case for dp
        for(int i = 0 ; i<= s2.length(); i++)prev[i]=0;

        for(int i = 1 ; i<=s1.length(); i++){
            int[]curr = new int[s2.length()+1];
            curr[0] = 0;
            for(int j =1 ; j<=s2.length(); j++){

                // matching condisont
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                }
                else{
                    curr[j] = 0+ Math.max(prev[j] , curr[j-1]);
                }
            }
            prev = curr;
        }
        return prev[s2.length()];
    }


}
