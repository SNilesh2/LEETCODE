class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        for(int[] arr : dp)
        {
            Arrays.fill(arr,-1);
        }
        return findPaths(m-1,n-1,obstacleGrid,dp);
    }

    public int findPaths(int r,int c,int[][] grid,int[][] dp)
    {
        if(r==0 && c==0 && grid[0][0]!=1)
        {
            return 1;
        }

        if(r<0 || c<0)
        {
            return 0;
        }

        if(grid[r][c]==1)
        {
            return 0;
        }

        if(dp[r][c]!=-1)
        {
            return dp[r][c];
        }

        int top = findPaths(r-1,c,grid,dp);

        int left = findPaths(r,c-1,grid,dp);

        return dp[r][c] = top + left;
    }
}