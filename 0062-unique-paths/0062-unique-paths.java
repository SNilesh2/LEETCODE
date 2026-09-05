class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return findUniquePaths(m,n,dp);
    }
    public int findUniquePaths(int r,int c,int[][] dp)
    {
        dp[0][0] = 1;

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
                if(j-1 >=0)
                {
                    left = dp[i][j-1];
                }
                
                dp[i][j] = top + left;
            }
        }

        return dp[r-1][c-1];
    }
}