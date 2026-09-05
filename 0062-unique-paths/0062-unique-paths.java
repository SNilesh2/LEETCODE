class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] arr : dp)
        {
            Arrays.fill(arr,-1);
        }
        return findUniquePaths(m-1,n-1,dp);
    }
    public int findUniquePaths(int r,int c,int[][] dp)
    {
        if(r==0 && c==0)
        {
            return 1;
        }

        if(r<0 || c<0)
        {
            return 0;
        }

        if(dp[r][c]!=-1)
        {
            return dp[r][c];
        }

        int top = findUniquePaths(r-1,c,dp);

        int left = findUniquePaths(r,c-1,dp);

        return dp[r][c] = top + left;
    }
}