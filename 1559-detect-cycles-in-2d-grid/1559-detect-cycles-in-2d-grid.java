class Solution {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(visited[i][j]==0)
                {
                    if(dfs(grid[i][j],i,j,grid,visited,-1,-1,m,n))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean dfs(char initChar,int row,int col,char[][] grid,int[][] vis,int parRow,int parCol,int m,int n)
    {
        vis[row][col] = 1;

        int[] drow = {0,1,0,-1};
        int[] dcol = {1,0,-1,0};

        for(int i=0;i<4;i++)
        {
            int newRow = row + drow[i]; 
            int newCol = col + dcol[i];

            if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && grid[newRow][newCol]==initChar && vis[newRow][newCol]==0)
            {
                if(dfs(initChar,newRow,newCol,grid,vis,row,col,m,n))
                {
                    return true;
                }
            }
            else if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && grid[newRow][newCol]==initChar && vis[newRow][newCol]==1 && newRow!=parRow && newCol!=parCol)
            {
                return true;
            }
        }
        return false;
    }
}