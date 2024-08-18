class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        int[][] vis=new int[m][n];
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if((i==0 || i==m-1 || j==0 || j==n-1) && vis[i][j]==0 && board[i][j]=='O')
                {
                    dfs(i,j,board,vis,drow,dcol);
                }
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]=='O' && vis[i][j]==0)
                {
                    board[i][j]='X';
                }
            }
        }
    }
    public static void dfs(int r,int c,char[][] board,int[][] vis,int[] drow,int[] dcol)
    {
        vis[r][c]=1;
        for(int i=0;i<4;i++)
        {
            int adjrow=r+drow[i];
            int adjcol=c+dcol[i];
            if(adjrow>=0 && adjrow<board.length && adjcol>=0 && adjcol<board[0].length && board[adjrow][adjcol]=='O' && vis[adjrow][adjcol]==0)
            {
                dfs(adjrow,adjcol,board,vis,drow,dcol);
            }
        }
    }
}