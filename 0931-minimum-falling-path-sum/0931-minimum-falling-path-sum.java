class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int res=Integer.MAX_VALUE;
        int[][] dp=new int[n][n];
        for(int[] row:dp)
        {
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        for(int j=0;j<n;j++)
        {
            int mini=fun(n-1,j,matrix,n,dp);
            res=Math.min(res,mini);
        }
        return res;
    }
    public static int fun(int i,int j,int[][] matrix,int n,int[][] dp)
    {
        if(j<0 || j>n-1) return Integer.MAX_VALUE;
        if(i==0) return matrix[i][j];
        if(dp[i][j]!=Integer.MAX_VALUE) return dp[i][j];
        int up=fun(i-1,j,matrix,n,dp);
        int rightdiag=fun(i-1,j-1,matrix,n,dp);
        int leftdiag=fun(i-1,j+1,matrix,n,dp);
        return dp[i][j]=matrix[i][j]+Math.min(up,Math.min(rightdiag,leftdiag));
    }
}