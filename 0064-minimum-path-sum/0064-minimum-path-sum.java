class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for(int[] arr : dp)
        {
            Arrays.fill(arr,-1);
        }

        return findMinPath(m-1,n-1,grid,dp);
    }

    public int findMinPath(int r,int c,int[][] grid,int[][] dp)
    {
        if(r==0 && c==0)
        {
            return grid[0][0];
        }

        if(r<0 || c<0)
        {
            return Integer.MAX_VALUE;
        }

        if(dp[r][c]!=-1)
        {
            return dp[r][c];
        }

        int top = findMinPath(r-1,c,grid,dp);

        int left = findMinPath(r,c-1,grid,dp);

        return dp[r][c] = Math.min(top,left) + grid[r][c];
    }
}