class Pair
{
    int r;
    int c;
    public Pair(int r,int c)
    {
        this.r = r;
        this.c = c;
    }
}

class Solution {
    public void solve(char[][] board) {
        int[][] vis = new int[board.length][board[0].length];

        for(int i=0;i<board[0].length;i++)
        {
            if(board[0][i]=='O')
            {
                bfs(0,i,board,vis);
            }
        }

        for(int i=0;i<board[0].length;i++)
        {
            if(board[board.length-1][i]=='O')
            {
                bfs(board.length-1,i,board,vis);
            }
        }

        for(int i=0;i<board.length;i++)
        {
            if(vis[i][0]==0 && board[i][0]=='O')
            {
                bfs(i,0,board,vis);
            }
        }

        for(int i=0;i<board.length;i++)
        {
            if(vis[i][board[0].length-1]==0 && board[i][board[0].length-1]=='O')
            {
                bfs(i,board[0].length-1,board,vis);
            }
        }


        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(vis[i][j]==0 && board[i][j]=='O')
                {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void bfs(int r,int c,char[][] board,int[][] vis)
    {
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(r,c));
        vis[r][c] = 1;

        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};

        while(!q.isEmpty())
        {
            Pair p = q.poll();

            int row = p.r;
            int col = p.c;

            for(int i=0;i<4;i++)
            {
                int nr = row + drow[i];
                int nc = col + dcol[i];

                if(nr>=0 && nr<board.length && nc>=0 && nc<board[0].length && vis[nr][nc]==0 && board[nr][nc]=='O')
                {
                    vis[nr][nc] = 1;
                    q.add(new Pair(nr,nc));
                }
            }
        }
    }
}