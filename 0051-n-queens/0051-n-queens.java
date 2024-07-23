class Solution {
    public List<List<String>> solveNQueens(int n) {
        char board[][]=new char[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j]='.';
            }
        }
        List<List<String>> res=new ArrayList<List<String>>();
        int[] leftrow=new int[n];
        int[] upperdiag=new int[2*n-1];
        int[] lowerdiag=new int[2*n-1];
        solve(0,board,res,leftrow,upperdiag,lowerdiag);
        return res;
    }
    public static void solve(int col,char[][] board,List<List<String>> res,int[] leftrow,int[] upperdiag,int[] lowerdiag)
    {
        if(col==board.length)
        {
            res.add(construct(board));
        }
        for(int row=0;row<board.length;row++)
        {
            if(leftrow[row]==0 && upperdiag[row+col]==0 && lowerdiag[board.length-1+col-row]==0)
            {
                board[row][col]='Q';
                leftrow[row]=1;
                upperdiag[row+col]=1;
                lowerdiag[board.length-1+col-row]=1;
                solve(col+1,board,res,leftrow,upperdiag,lowerdiag);
                board[row][col]='.';
                leftrow[row]=0;
                upperdiag[row+col]=0;
                lowerdiag[board.length-1+col-row]=0;
            }
        }
    }
    public static List<String> construct(char[][] board)
    {
        List<String> ans=new LinkedList<>();
        for(int i=0;i<board.length;i++)
        {
            String s=new String(board[i]);
            ans.add(s);
        }
        return ans;
    }
}