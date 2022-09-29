package Practise;

public class Word {
    public static void main(String[] args) {
        String word="ESEC";
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        boolean value = exist(board,word);
        System.out.println(value);

    }
    public  static boolean exist(char[][] board, String word) {
        boolean [][] ans = new boolean[board.length][board[0].length];
        boolean[]ans1= new boolean[1];
        for(int i=0 ;i< board.length; i++)
        {
            for (int j = 0; j <board[0].length; j++) {
               if(board[i][j]==word.charAt(0))
               {
                   call(board, word, ans,i,j,ans1);
                   if(ans1[0])
                       return true;
               }
            }
        }

        return false;

    }
    public static void call(char[][]board, String word,boolean[][]ans , int row, int col ,boolean[]ans1 )
    {  if(word.isEmpty())
    {
        ans1[0] = true;
        return;
    }
     if(ans[row][col]==true)
            return;

    char ch = word.charAt(0);
    if(word.length()==1 && board[row][col]==ch)
    {
        ans1[0]=true;
        return;
    }

        ans[row][col]=true;
     if(board[row][col]==ch)
    {

        // left parsing
        if(col>0)
            call(board,word.substring(1),ans ,row,col-1,ans1);

        // right parsing
        if(col<board[0].length-1)
            call(board,word.substring(1),ans,row, col+1, ans1);

        //up parisng
        if(row>0)
            call(board, word.substring(1), ans, row-1, col, ans1);

        //down parisng
        if(row<board.length-1)
            call(board,word.substring(1), ans, row+1, col, ans1);
    }

    else
    {
        ans[row][col]=false;
        return ;
         }


}
}
