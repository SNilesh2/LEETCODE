class Solution {
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] visited=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if((i==0 || j==0 || i==m-1 || j==n-1) && grid[i][j]==1)
                {
                    dfs(i,j,grid,visited,m,n);
                }
            }
        }
        int cnt=0;
        for(int i=1;i<m-1;i++)
        {
            for(int j=1;j<n-1;j++)
            {
                if(visited[i][j]==0 && grid[i][j]==1)
                {
                    cnt++;
                }
            }
        }
        return cnt;
    }
    int[] drow={-1,0,1,0};
    int[] dcol={0,1,0,-1};
    public void dfs(int row,int col,int[][] grid,int[][] visited,int m,int n)
    {
        visited[row][col]=1;
        for(int i=0;i<4;i++)
        {
            int nrow=row+drow[i];
            int ncol=col+dcol[i];
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && visited[nrow][ncol]==0 && grid[nrow][ncol]==1)
            {
                dfs(nrow,ncol,grid,visited,m,n);
            }
        }
    }
}