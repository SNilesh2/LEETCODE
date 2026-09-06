class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        return findMinPath(m,n,grid,dp);
    }

    public int findMinPath(int r,int c,int[][] grid,int[][] dp)
    {
        // if(r==0 && c==0)
        // {
        //     return grid[0][0];
        // }
        // if(r<0 || c<0)
        // {
        //     return Integer.MAX_VALUE;
        // }
        // if(dp[r][c]!=-1)
        // {
        //     return dp[r][c];
        // }
        // int top = findMinPath(r-1,c,grid,dp);
        // int left = findMinPath(r,c-1,grid,dp);
        // return dp[r][c] = Math.min(top,left) + grid[r][c];

        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(i==0 && j==0)
                {
                    dp[0][0] = grid[0][0];
                    continue;
                }

                int top = Integer.MAX_VALUE;
                if(i-1 >= 0)
                {
                    top = dp[i-1][j];
                }

                int left = Integer.MAX_VALUE;
                if(j-1 >= 0)
                {
                    left = dp[i][j-1];
                }

                dp[i][j] = Math.min(top,left) + grid[i][j];
            }
        }

        return dp[r-1][c-1];
    }
}