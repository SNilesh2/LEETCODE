class Pair
{
    int row;
    int col;
    public Pair(int row,int col)
    {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int[][] vis = new int[grid.length][grid[0].length];

        int result = 0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1' && vis[i][j]==0)
                {
                    result++;
                    bfs(grid,vis,i,j);
                }
            }
        }

        return result;
    }

    public static void bfs(char[][] grid,int[][] vis,int row,int col)
    {
        vis[row][col]=1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row,col));
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        while(!q.isEmpty())
        {
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;

            for(int i=0;i<4;i++)
            {
                int nr = r + drow[i];
                int nc = c + dcol[i];

                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]=='1' && vis[nr][nc]==0)
                {
                    q.add(new Pair(nr,nc));
                    vis[nr][nc]=1;
                }
            }
        }
    }
}