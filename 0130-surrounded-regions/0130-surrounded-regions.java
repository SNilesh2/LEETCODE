class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] vis = new int[rows][cols];

        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if((i==0 || j==0 || i==rows-1 || j==cols-1) && board[i][j]=='O')
                {
                    dfs(i,j,board,vis);
                }
            }
        }

        for(int i=1;i<rows;i++)
        {
            for(int j=1;j<cols;j++)
            {
                if(board[i][j]=='O' && vis[i][j]==0)
                {
                    board[i][j] = 'X';
                }
            }
        }
    }
    public static void dfs(int row ,int col,char[][] board,int[][] vis)
    {
        vis[row][col] = 1;

        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};

        for(int i=0;i<4;i++)
        {
            int nr = row + drow[i];
            int nc = col + dcol[i];

            if(nr>=0 && nr<board.length && nc>=0 && nc<board[0].length && board[nr][nc]=='O' && vis[nr][nc]==0)
            {
                dfs(nr,nc,board,vis);
            }
        }
    }
}