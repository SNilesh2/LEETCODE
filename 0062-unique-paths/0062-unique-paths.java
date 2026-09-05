class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return findUniquePaths(m,n,dp);
    }
    public int findUniquePaths(int r,int c,int[][] dp)
    {
        //making all the 0th row value as 0
        for(int i=0;i<r;i++)
        {
            dp[i][0] = 1;
        }
        //making all the 0th column values as 0
        for(int i=0;i<c;i++)
        {
            dp[0][i] = 1;
        }
        for(int i=1;i<r;i++)
        {
            for(int j=1;j<c;j++)
            {
                int top = dp[i-1][j];
                int left = dp[i][j-1];
                dp[i][j] = top + left;
            }
        }

        return dp[r-1][c-1];
    }
}