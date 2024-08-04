class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        return fun(m,n,grid,dp);
    }
    //memoization
   /* public static int fun(int i,int j,int[][] grid,int[][] dp) 
    {
        if(i<0 || j<0) return Integer.MAX_VALUE;
        if(i==0 && j==0) return grid[i][j];
        if(dp[i][j]!=-1) return dp[i][j];
        int up=fun(i-1,j,grid,dp);
        int left=fun(i,j-1,grid,dp);
        return dp[i][j]=grid[i][j]+Math.min(up,left);
    }*/
    //tablulation
    public static int fun(int m,int n,int[][] grid,int[][] dp)
    {
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int up,left;
                if(i==0 && j==0) dp[i][j]=grid[i][j];
                else
                {
                if(i>0) up=dp[i-1][j];
                else up=Integer.MAX_VALUE;
                if(j>0) left=dp[i][j-1];
                else left=Integer.MAX_VALUE;
                dp[i][j]=grid[i][j]+Math.min(up,left);
                }
            }
        }
        return dp[m-1][n-1];
    }
}