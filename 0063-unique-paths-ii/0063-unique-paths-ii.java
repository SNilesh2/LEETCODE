class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        return findPaths(m,n,obstacleGrid,dp);
    }

    public int findPaths(int r,int c,int[][] grid,int[][] dp)
    {
        dp[0][0] = (grid[0][0]==0) ? 1 : 0;

        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(i==0 && j==0)
                {
                    continue;
                }

                int top = 0;
                if(i-1 >= 0)
                {
                    top = dp[i-1][j];
                }

                int left = 0;
                if(j-1 >= 0)
                {
                    left = dp[i][j-1];
                }

                dp[i][j] = (grid[i][j]==0) ? (top + left) : 0;
            }
        }

        return dp[r-1][c-1];
    }
}