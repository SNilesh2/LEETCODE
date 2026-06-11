class Solution {
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] vis = new int[rows][cols];

        //first row
        for(int col=0;col<cols;col++)
        {
            if(grid[0][col]==1)
            {
                dfs(0,col,grid,vis);
            }
        }

        //last row
        for(int col=0;col<cols;col++)
        {
            if(grid[rows-1][col]==1)
            {
                dfs(rows-1,col,grid,vis);
            }
        }

        //first col
        for(int row=1;row<rows-1;row++)
        {
            if(grid[row][0]==1)
            {
                dfs(row,0,grid,vis);
            }
        }

        //last col
        for(int row=1;row<rows-1;row++)
        {
            if(grid[row][cols-1]==1)
            {
                dfs(row,cols-1,grid,vis);
            }
        }

        int result = 0;
        for(int i=1;i<rows-1;i++)
        {
            for(int j=1;j<cols-1;j++)
            {
                if(grid[i][j]==1 && vis[i][j]==0)
                {
                    result++;
                }
            }
        }

        return result;
    }

    public static void dfs(int row,int col,int[][] grid,int[][] vis)
    {
        vis[row][col] = 1;

        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};

        for(int i=0;i<4;i++)
        {
            int nr = row + drow[i];
            int nc = col + dcol[i];

            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==1 && vis[nr][nc]==0)
            {
                dfs(nr,nc,grid,vis);
            }
        }
    }
}